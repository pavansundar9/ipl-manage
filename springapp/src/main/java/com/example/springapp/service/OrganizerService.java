package com.example.springapp.service;

import java.util.List;

import com.example.springapp.entity.Player;

/**
 * @author PAVAN SUNDAR 10828911
 * Service interface for managing organizer-related operations.
 * 
 * Defines the contract for the `OrganizerServiceImpl` class, ensuring a consistant structure for operations related to organizing  players and teams.
 */
public interface OrganizerService {
    
    /**
     * Retrieves a list of unsold players.
     *
     * @return a list of unsold `Player` entities.
     */
    List<Player> getUnsoldPlayers();
    
    /**
     * Retrieves a list of sold players.
     *
     * @return a list of sold `Player` entities.
     */
    List<Player> getSoldPlayers();

    /**
     * Assigns a player to a specific team.
     *
     * @param playerId the ID of the player to be assigned.
     * @param teamId   the ID of the team to assign the player to.
     */
    void assignPlayerToTeam(Long playerId, Long teamId);

    /**
     * Releases a player from their current team.
     *
     * @param id the ID of the player to be released.
     */
    void releasePlayerFromTeam(Long playerId);

    /**
     * Retrieves a list of players belonging to a specific team.
     *
     * @param id the ID of the team.
     * @return a list of players associated with the team.
     */
    List<Player> getPlayerListByTeamId(Long teamId);
}