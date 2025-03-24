package com.example.springapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author PAVAN SUNDAR 10828911
 * Entity class representing a Player.
 * Annotated with `@Entity` to map the class to a database table.
 * Uses Lombok annotations like `@Getter`, `@Setter`, `@NoArgsConstructor`, and `@AllArgsConstructor` to auto-generate boilerplate code.
 */

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    /**
     * Unique identifier for a player.
     * Annotated with `@Id` to denote the primary key.
     * Uses `@GeneratedValue` with the strategy `GenerationType.AUTO` for automatic ID generation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;    /*  Name of the player. */
    private int age;    /* Age of the player. */
    private String category;    /* Category of the player (e.g., batsman, bowler). */
    private double biddingPrice;    /* Bidding price for the player. */
    private boolean sold;   /* Status indicating whether the player has been sold. */

    /**

     * Team associated with the player.
     * 
     * Annotated with `@ManyToOne` to denote the many-to-one relationship with the `Team` entity.
     * Uses `@JoinColumn` to specify the foreign key column name in the database.
     */
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
