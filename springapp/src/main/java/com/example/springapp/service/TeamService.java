package com.example.springapp.service;

import java.util.List;

import com.example.springapp.entity.Team;

/**
 * @author PAVAN SUNDAR 10828911
 * Service interface for managing team-related operations.
 * 
 * Defines the contract for the `TeamServiceImpl` class, providing methods for team CRUD operations.
 */
public interface TeamService {

     /**
     * Saves a new team to the database.
     *
     * @param team the `Team` entity to be saved.
     * @return the saved `Team` entity.
     */
    Team saveTeam(Team team);

    /**
     * Updates an existing team by ID.
     *
     * @param teamId the ID of the team to update.
     * @param team   the updated `Team` entity details.
     * @return the updated `Team` entity if found, or throws an exception if not found.
     */
    Team updateTeam(Long teamId, Team team);

    /**
     * Retrieves all teams from the database.
     *
     * @return a list of all `Team` entities.
     */
    List<Team> getAllTeams();

    /**
     * Retrieves a team by ID.
     *
     * @param teamId the ID of the team to retrieve.
     * @return the `Team` entity if found, or `null` otherwise.
     */
    Team getTeamById(Long teamId);

    /**
     * Deletes a team by ID.
     *
     * @param teamId the ID of the team to delete.
     */
    Team deleteTeamById(Long teamId);
}