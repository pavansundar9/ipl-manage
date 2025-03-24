package com.example.springapp.service;

import java.util.List;

import com.example.springapp.entity.Player;

/**
 * @author PAVAN SUNDAR 10828911
 * Service interface for managing player-related operations.
 * 
 * Defines the contract for the `PlayerServiceImpl` class, providing methods for team CRUD operations.
*/
public interface PlayerService {

    /**
     * Adds a new player to the database.
     *
     * @param player the `Player` entity to be added.
     * @return the saved `Player` entity.
     */
    Player addPlayer(Player player);

    /**
     * Updates an existing player by ID.
     *
     * @param id     the ID of the player to update.
     * @param player the updated `Player` entity details.
     * @return the updated `Player` entity if found, or `null` otherwise.
     */
    Player updatePlayerById(Long id, Player player);
    
    /**
     * Retrieves all players from the database.
     *
     * @return a list of all `Player` entities.
     */
    List<Player> getAllPlayers();

    /**
     * Retrieves a player by ID.
     *
     * @param id the ID of the player to retrieve.
     * @return the `Player` entity if found, or `null` otherwise.
     */
    Player getPLayerById(Long id);

    /**
     * Deletes a player by ID.
     *
     * @param id the ID of the player to delete.
     * @return the deleted `Player` entity if found, or `null` otherwise.
     */
    Player deletePlayerById(Long id);
}
