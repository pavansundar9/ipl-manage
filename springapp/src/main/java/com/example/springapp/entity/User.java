package com.example.springapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author PAVAN SUNDAR 10828911
 * Entity class representing a User.
 * 
 * Annotated with `@Entity` to map the class to a database table.
 * Uses Lombok annotations like `@Getter`, `@Setter`, `@NoArgsConstructor`, and `@AllArgsConstructor` to auto-generate boilerplate code.
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {

     /**
     * Unique identifier for a team.
     * Annotated with `@Id` to denote the primary key.
     * Uses `@GeneratedValue` with the strategy `GenerationType.IDENTITY` for ID generation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String username;
    private String password;
    private String role;

}