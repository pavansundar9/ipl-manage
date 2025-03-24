package com.example.springapp.exceptions;

/**
 * @author PAVAN SUNDAR 10828911
 * Custom exception to handle scenarios where a team's budget is exceeded.
 * 
 * Extends `RuntimeException` to allow unchecked exceptions.
 */
public class ExceedsTeamBudgetException extends RuntimeException{
    /**
     * Constructor for `ExceedsTeamBudgetException`.
     *
     * @param msg the exception message describing the error.
     */
    public ExceedsTeamBudgetException(String msg){
        super(msg);
    }
}
