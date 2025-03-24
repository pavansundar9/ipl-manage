package com.example.springapp.exceptions;

/**
 * @author PAVAN SUNDAR 10828911
 * Custom exception to handle scenarios where a player is already assigned to a team.
 * 
 * Extends `RuntimeException` to allow unchecked exceptions.
 */
public class PlayerAlreadyAssignedException extends RuntimeException{
    /**
    * Constructor for `PlayerAlreadyAssignedException`.
    *
    * @param msg the exception message describing the error.
    */
   public PlayerAlreadyAssignedException(String msg){
       super(msg);
   }
}