package com.example.springapp.service;

import java.util.List;

import com.example.springapp.entity.AuthUser;
import com.example.springapp.entity.User;

/**
 * @author PAVAN SUNDAR 10828911
 * Service interface for managing user-related operations.
 * <p>
 * Defines the contract for `UserServiceImpl`, specifying methods to handle user
 * registration, authentication, and retrival.
 */
public interface UserService {
    /**
     * Registers a new user in the system.
     * 
     * @param user the `User` entity containing user details to b saved.
     * @return the saved `User` entity after successful registration.
     */
    User registerUser(User user);

    /**
     * Retrieves a list of users from the database.
     *
     * @return a list of sold `User` entities.
     */
    List<User> getAllUsers();

    /**
     * Autehnticates a user by validation their credentials.
     * 
     * @param user the `User` entity containing login credentials(e.g. user ID and password).
     * @return the authenticated `User` entity if credentials match, or `null` otherwise.
     */
    AuthUser loginUser(User user);
}