package com.example.springapp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author PAVAN SUNDAR 10828911
 * Entity class representing a Team.
 * 
 * Annotated with `@Entity` to map the class to a database table.
 * Uses Lombok annotations like `@Getter`, `@Setter`, `@NoArgsConstructor`, and `@AllArgsConstructor` to auto-generate boilerplate code.
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team {

     /**
     * Unique identifier for a team.
     * Annotated with `@Id` to denote the primary key.
     * Uses `@GeneratedValue` with the strategy `GenerationType.IDENTITY` for ID generation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;    /* Name of the team. */
    private double maximumBudget;   /* Maximum budget allocated for the team. */

    /**
     * List of players associated with the team.
     * 
     * Annotated with `@OneToMany` to denote the one-to-many relationship with the `Player` entity.
     * Uses `@JsonIgnore` to prevent circular references during JSON serialization.
     */
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Player> players;

    /**
     * Custom constructor for initializing a team with specific attributes.
     *
     * @param id             the unique identifier of the team.
     * @param name           the name of the team.
     * @param maximumBudget  the budget allocated to the team.
     */
    public Team(Long id, String name, double maximumBudget){
        this.id = id;
        this.name = name;
        this.maximumBudget = maximumBudget;
    }
}