package com.example.springapp.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.entity.Player;
import com.example.springapp.entity.Team;
import com.example.springapp.exceptions.EntityNotFoundException;
import com.example.springapp.exceptions.ExceedsTeamBudgetException;
import com.example.springapp.exceptions.PlayerAlreadyAssignedException;
import com.example.springapp.repository.PlayerRepo;
import com.example.springapp.repository.TeamRepo;
import com.example.springapp.service.OrganizerService;


/**
 * @author PAVAN SUNDAR 10828911
 * Service implementation for managing organizer-related operations.
 * 
 * Annotated with `@Service` to indicate it's a Spring service class.
 * Implements the `OrganizerService` interface to provide specific business logic.
 */

@Service
public class OrganizerServiceImpl implements OrganizerService {

    /**
     * Repository for managing `Player` entity data access.
     * Annotated with `@Autowired` to inject the `PlayerRepo` bean.
     */
    @Autowired
    private PlayerRepo playerRepo;

    /**
     * Repository for managing `Team` entity data access.
     * Annotated with `@Autowired` to inject the `TeamRepo` bean.
     */
    @Autowired
    private TeamRepo teamRepo;
    
    /**
     * Retrieves a list of unsold players.
     *
     * @return a list of unsold `Player` entities.
     */
    @Override
    public List<Player> getUnsoldPlayers() {
        return playerRepo.findBySold(false);
    }

     /**
     * Retrieves a list of sold players.
     *
     * @return a list of sold `Player` entities.
     */
    @Override
    public List<Player> getSoldPlayers(){
        return playerRepo.findBySold(true);
    }

     /**
     * Assigns a player to a team.
     *
     * @param playerId the ID of the player to be assigned.
     * @param teamId   the ID of the team to assign the player to.
     * @throws PlayerAlreadyAssignedException if the player is already assigned to a team.
     * @throws ExceedsTeamBudgetException     if the player's bidding price exceeds the team's budget.
     * @throws PlayerNotFoundException        if the player does not exist.
     * @throws TeamNotFoundException          if the team does not exist.
     */
    @Override
    public void assignPlayerToTeam(Long playerId, Long teamId) {
        Player player = playerRepo.findById(playerId).orElseThrow(null);
        Team team = teamRepo.findById(teamId).orElse(null);

        if(player == null)
            throw new EntityNotFoundException("Player not found.");
            
        if(team == null)
            throw new EntityNotFoundException("Team not found.");
            
        if(player.isSold()){
            throw new PlayerAlreadyAssignedException("Player is already assigned to a team");
        }

        List<Player> palyers = team.getPlayers();
        double totalBudget = 0;
        for(Player p: palyers){
            totalBudget+=p.getBiddingPrice();
        }
        if (totalBudget + player.getBiddingPrice() > team.getMaximumBudget()) {
            throw new ExceedsTeamBudgetException("Exceeds team budget");
        }
        
        
        player.setTeam(team);
        player.setSold(true);
        playerRepo.save(player);
    }	
    
     /**
     * Releases a player from their current team.
     *
     * @param id the ID of the player to be released.
     * @throws PlayerNotFoundException        if the player does not exist.
     */
    @Override
    public void releasePlayerFromTeam(Long playerId) {
        Player player = playerRepo.findById(playerId).orElse(null);
        
        if(player == null)
            throw new EntityNotFoundException("Player not found.");
        
        player.setTeam(null);
        player.setSold(false);
        playerRepo.save(player);
    }

    /**
     * Retrieves a list of players belonging to a specific team.
     *
     * @param id the ID of the team.
     * @throws TeamNotFoundException          if the team does not exist.
     * @return a list of players associated with the team.
     */
    @Override
    public List<Player> getPlayerListByTeamId(Long teamId) {
        Team team = teamRepo.findById(teamId).orElseThrow(null);

        // if(team == null)
        //     throw new TeamNotFoundException("Team not found.");
        
        return team.getPlayers();
    }
}