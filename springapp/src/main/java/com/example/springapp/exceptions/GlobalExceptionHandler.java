package com.example.springapp.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author
 * Global exception handler for handling application-specific exceptions.
 * 
 * Annotated with `@Controller` to act as a Spring-managed component for exception handling.
 * Contains methods annotated with `@ExceptionHandler` to define custom error responses.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    /**
     * Handles `ExceedsTeamBudgetException` and returns an appropriate response.
     *
     * @param e the exception object.
     * @return a `ResponseEntity` with a 400 status code and the exception message.
     */
    @ExceptionHandler(ExceedsTeamBudgetException.class)
    public ResponseEntity<String> handleExceeds(ExceedsTeamBudgetException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }

     /**
     * Handles `PlayerAlreadyAssignedException` and returns an appropriate response.
     *
     * @param e the exception object.
     * @return a `ResponseEntity` with a 409 status code and the exception message.
     */
    @ExceptionHandler(PlayerAlreadyAssignedException.class)
    public ResponseEntity<String> handlePlayer(PlayerAlreadyAssignedException e){
        return ResponseEntity.status(409).body(e.getMessage());
    }
    
    /**
    * Handles `PlayerNotFoundException` and returns an appropriate response.
    *
    * @param e the exception object.
    * @return a `ResponseEntity` with a 404 status code and the exception message.
    */
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handlePlayerNotFound(EntityNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }
    
    /**
    * Handles `InvalidCredentialsException` and returns an appropriate response.
    *
    * @param e the exception object.
    * @return a `ResponseEntity` with a 404 status code and the exception message.
    */
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> handleInavlidCredentials(InvalidCredentialsException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }
    
}