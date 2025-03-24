package com.example.springapp.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.entity.Player;
import com.example.springapp.exceptions.EntityNotFoundException;
import com.example.springapp.repository.PlayerRepo;
import com.example.springapp.service.PlayerService;

/**
 * @author PAVAN SUNDAR 10828911
 * Service implementation for managing player-related operations.
 * 
 * Annotated with `@Service` to indicate it's a Spring service class.
 * Implements the `PlayerService` interface to provide specific business logic.
 */

@Service
public class PlayerServiceImpl implements PlayerService{
    
    /**
     * Repository for managing `Player` entity data access.
     * Annotated with `@Autowired` to inject the `PlayerRepo` bean.
     */
    @Autowired
    private PlayerRepo playerRepo;

    /**
     * Adds a new player to the database.
     *
     * @param player the `Player` entity to be added.
     * @return the saved `Player` entity.
     */
    @Override
    public Player addPlayer(Player player){
        return playerRepo.save(player);
    }

    /**
     * Updates an existing player by ID.
     *
     * @param id     the ID of the player to update.
     * @param player the updated `Player` entity details.
     * @return the updated `Player` entity if found, or `null` otherwise.
     * @throws PlayerNotFoundException        if the player does not exist.
     */
    @Override
    public Player updatePlayerById(Long id, Player player){
        Player obj = playerRepo.findById(id).orElse(null);
        if(obj!=null){
            if(player.getAge()>0)
                obj.setAge(player.getAge());
            if(player.getBiddingPrice()>=0)
                obj.setBiddingPrice(player.getBiddingPrice());
            
            obj.setSold(player.isSold());
            
            if(player.getName()!=null)
                obj.setName(player.getName());
            return playerRepo.save(obj);
        }
        else{
            throw new EntityNotFoundException("Player not found with ID: "+id);
        }
    }

    /**
     * Retrieves all players from the database.
     *
     * @return a list of all `Player` entities.
     */
    @Override
    public List<Player> getAllPlayers(){
        return playerRepo.findAll();
    }

    /**
     * Retrieves a player by ID.
     *
     * @param id the ID of the player to retrieve.
     * @throws PlayerNotFoundException        if the player does not exist.
     * @return the `Player` entity if found, or `null` otherwise.
     */
    @Override
    public Player getPLayerById(Long id){
        Player player = playerRepo.findById(id).orElse(null);
        if(player==null)
            throw new EntityNotFoundException("Player not found with ID: "+id);
        return player;
    }


    /**
     * Retrieves a player list by team ID.
     *
     * @param temaId the ID of the team the players need to be retrieved.
     * @return the list of `Player` in the team.
     */
    public List<Player> getPlayerListByTeamId(Long teamId){
        return playerRepo.findByTeamId(teamId);
    }
    /**
     * Deletes a player by ID.
     *
     * @param id the ID of the player to delete.
     * @throws PlayerNotFoundException        if the player does not exist.
     * @return the deleted `Player` entity if found, or `null` otherwise.
     */
    @Override
    public Player deletePlayerById(Long id){
        Player obj = playerRepo.findById(id).orElse(null);
        if(obj!=null){
            playerRepo.deleteById(id);
            return obj;
        }
        else{
            throw new EntityNotFoundException("Player not found with ID: "+id);
        }
    }

}