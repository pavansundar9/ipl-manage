package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.entity.Player;
import com.example.springapp.service.serviceImpl.PlayerServiceImpl;


/**
 * Controller class for managing player-related endpoints.
 * @author PAVAN SUNDAR 10828911
 * Annotated with `@RestController` to indicate a RESTful controller.
 * Mapped to the `/api` base path using `@RequestMapping`.
 */

@RestController
@RequestMapping("/api")
public class PlayerController {

    /**
     * Service implementation for player operations.
     * Annotated with `@Autowired` to inject the `PlayerServiceImpl` bean.
     */
    @Autowired
    private PlayerServiceImpl playerServiceImpl;


    /**
     * Adds a new player.
     *
     * @param player the `Player` entity provided in the request body.
     * @return a `ResponseEntity` containing the saved `Player` entity or an error status.
     */
    @PostMapping("/player")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player obj = playerServiceImpl.addPlayer(player);
        return ResponseEntity.status(200).body(obj);
    }
    
    /**
     * Updates an existing player by ID.
     *
     * @param playerId the ID of the player to be updated.
     * @param player   the updated `Player` entity provided in the request body.
     * @return a `ResponseEntity` containing the updated `Player` entity or an error status.
     */
    @PutMapping("/player/{playerId}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long playerId, @RequestBody Player player){
        Player obj = playerServiceImpl.updatePlayerById(playerId, player);
        if(obj!=null)
            return ResponseEntity.status(200).body(obj);
        return ResponseEntity.status(500).body(null);
    }
    
    @GetMapping("/organizer/team/{teamId}/players")
    public ResponseEntity<List<Player>> getPlayerListByTeamId(@PathVariable Long teamId){
        List<Player> playerList = playerServiceImpl.getPlayerListByTeamId(teamId);
        if(playerList!=null)
            return ResponseEntity.status(200).body(playerList);
        return ResponseEntity.status(500).body(null);
    }

    /**
     * Retrieves all players.
     *
     * @return a `ResponseEntity` containing a list of all `Player` entities.
     */
    @GetMapping("/player")
    public ResponseEntity<List<Player>> getAllPlayer(){
        List<Player> obj = playerServiceImpl.getAllPlayers();
        if(obj!=null)
            return ResponseEntity.status(200).body(obj);
        return ResponseEntity.status(500).body(null);
    }
    
    /**
     * Retrieves a player by ID.
     *
     * @param playerId the ID of the player to be retrieved.
     * @return a `ResponseEntity` containing the `Player` entity or an error status.
     */
    @GetMapping("/player/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long playerId){
        Player obj = playerServiceImpl.getPLayerById(playerId);
        if(obj!=null)
            return ResponseEntity.status(200).body(obj);
        return ResponseEntity.status(500).body(null);
    }
    
    /**
     * Deletes a player by ID.
     *
     * @param playerId the ID of the player to be deleted.
     * @return a `ResponseEntity` indicating the success or failure of the operation.
     */
    @DeleteMapping("/player/{playerId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long playerId){
        Player obj = playerServiceImpl.deletePlayerById(playerId);
        if(obj!=null)
            return ResponseEntity.status(200).body(true);
        return ResponseEntity.status(500).body(false);   
    }
}