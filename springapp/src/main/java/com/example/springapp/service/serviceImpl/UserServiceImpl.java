package com.example.springapp.service.serviceImpl;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springapp.configuration.JwtUtils;
import com.example.springapp.entity.AuthUser;
import com.example.springapp.entity.User;
import com.example.springapp.exceptions.InvalidCredentialsException;
import com.example.springapp.repository.UserRepo;
import com.example.springapp.service.UserService;


/**
 * @author PAVAN SUNDAR 10828911
 *         Service implementation for managing user-related operations.
 *         <p>
 *         Annotated with `@Service` to indicate it's a Spring service class.
 *         Implements `UserService` to define user-specific business logic.
 */

@Service
public class UserServiceImpl implements UserService {

    /**
     * Repository for user data access.
     * Annotated with `@Autowired` to "inject" the `UserRepo` bean.
     */

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    private static final List<String> validRoles = Arrays.asList("ADMIN", "ORGANIZER");

    /**
     * Registers a new user.
     * 
     * @param user the `User` entity to be saved.
     * @return the saved `User` entity.
     * @throws IllegalArgumentException if the given details does not contain `role`
     *                                  or is invalid role.
     */

    @Override
    public User registerUser(User user) {
        if (user.getRole() == null || !validRoles.contains(user.getRole().toUpperCase())) {
            throw new IllegalArgumentException("Valid role should be provided.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash password before saving

        User savedUser = userRepo.save(user); // Ensure user is saved

        if (savedUser == null || savedUser.getUserId() == null) {

            throw new RuntimeException("User registration failed."); // Error handling
        }

        System.out.println("User registered successfully: " + savedUser.getUsername()); // Debug log

        return savedUser;
    }

    /**
     * Retrieves all users from the database.
     * 
     * @return a list of all `User` entities.
     */

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    /**
     * Handles user login by validating credentials.
     *
     * @param user the `User` entity with login credentials.
     * @return the matched `User` entity if credentials are valid; otherwise,
     *         `null`.
     */

    @Override
    public AuthUser loginUser(User user) throws InvalidCredentialsException {
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            // Retrieve user details from the database
            User foundUser = userRepo.findByUsername(user.getUsername());
            System.out.println("\nUserServiceImpl-Found user: \n"+foundUser);

            if (foundUser == null || !passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
                System.out.println("\nUserServiceImpl:Inavlid Password or Username\n");
                throw new InvalidCredentialsException("Invalid username or password");
            }

            // // Extract roles
            // List<String> roleList = authentication.getAuthorities().stream()
            //         .map(r -> r.getAuthority())
            //         .collect(Collectors.toList());
            // String role = roleList.isEmpty() ? null : roleList.get(0);
            String token = jwtUtils.generateToken(foundUser.getUsername());
            System.out.println("\nnUserServiceImpl:"+token+"\n");
            // Create AuthUser object and populate it with user details and token
            AuthUser authUser = new AuthUser();
            authUser.setId(foundUser.getUserId());
            authUser.setUsername(foundUser.getUsername());
            authUser.setJwtToken(jwtUtils.generateToken(foundUser.getUsername())); // Pass the username to generateToken
            authUser.setRole(foundUser.getRole());
            System.out.println("\nUserServiceImpl: "+authUser+"\n");
            return authUser;
        }
        throw new InvalidCredentialsException("Invalid username or password");
    }

}