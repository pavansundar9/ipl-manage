package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.entity.AuthUser;
import com.example.springapp.entity.User;
import com.example.springapp.service.serviceImpl.UserServiceImpl;


/**
 * Controller class for managing user-related endpoints.
 * @author PAVAN SUNDAR 10828911
 * Annotated with `@RestController` to indicate a RESTful controller.
 * Mapped to the `/api/user` base path using `@RequestMapping`.
 */

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    /**
     * Service implementation for user operations.
     * Annotated with `@Autowired` to inject the `UserServiceImpl` bean.
     */

    @Autowired
    private UserServiceImpl userServiceImpl;


    /**
     * Registers a new user.
     *
     * @param user the `User` entity provided in the request body.
     * @return a `ResponseEntity` containing the saved `User` entity or an error status.
     */
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User obj = userServiceImpl.registerUser(user);
        if(obj != null)
            return ResponseEntity.status(201).body(obj);
        return ResponseEntity.status(500).body(null);
    }
    

     /**
     * Authenticates a user during login.
     *
     * @param user the `User` entity provided in the request body.
     * @return a `ResponseEntity` containing the authenticated `User` entity or an error status.
     */
    @PostMapping("/login")
    public ResponseEntity<AuthUser> loginUser(@RequestBody User user){
        AuthUser obj = userServiceImpl.loginUser(user);
        System.out.print("\nUserController: "+ obj+"\n");
        if(obj != null)
            return ResponseEntity.status(201).body(obj);
        return ResponseEntity.status(500).body(null);
    }

    /**
     * Retrieves all registered users.
     *
     * @return a `ResponseEntity` containing a list of all `User` entities or an error status.
     */
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> obj = userServiceImpl.getAllUsers();
        if(obj != null)
            return ResponseEntity.status(200).body(obj);
        return ResponseEntity.status(404).body(null);
    }

    @GetMapping("/test")
    public ResponseEntity<?> testApi(){
        return ResponseEntity.status(500).body("API is working");
    }
}
