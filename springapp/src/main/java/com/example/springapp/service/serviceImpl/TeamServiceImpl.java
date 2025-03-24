package com.example.springapp.service.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.entity.Team;
import com.example.springapp.exceptions.EntityNotFoundException;
import com.example.springapp.repository.TeamRepo;
import com.example.springapp.service.TeamService;


/**
 * @author PAVAN SUNDAR 10828911
 * Service implementation for managing team-related operations.
 * 
 * Annotated with `@Service` to indicate it's a Spring service class.
 * Implements the `TeamService` interface to provide specific business logic.
 */

@Service
public class TeamServiceImpl implements TeamService{

    /**
     * Repository for managing `Team` entity data access.
     * Annotated with `@Autowired` to inject the `TeamRepo` bean.
     */
    @Autowired 
    private TeamRepo teamRepo;

    /**
     * Saves a new team to the database.
     *
     * @param team the `Team` entity to be saved.
     * @return the saved `Team` entity.
     */
    @Override
    public Team saveTeam(Team team){
        return teamRepo.save(team);
    }

    /**
     * Updates an existing team by ID.
     *
     * @param teamId the ID of the team to update.
     * @param team   the updated `Team` entity details.
     * @return the updated `Team` entity if found, or throws an exception if not found.
     * @throws TeamNotFoundException if the team with the specified ID is not found.
     */
    @Override
    public Team updateTeam(Long teamId, Team team){
        Team obj = teamRepo.findById(teamId).orElse(null);

        if(obj!=null){
            if(team.getName()!=null)
                    obj.setName(team.getName());
            if(team.getMaximumBudget()>=0)
                obj.setMaximumBudget(team.getMaximumBudget());
            return teamRepo.save(obj);
        }else{
            throw new EntityNotFoundException("Team not found with id "+teamId);
        }
    }
     
    /**
     * Retrieves all teams from the database.
     *
     * @return a list of all `Team` entities.
     */
    @Override
    public List<Team> getAllTeams(){
        return teamRepo.findAll();
    }

     /**
     * Retrieves a team by ID.
     *
     * @param teamId the ID of the team to retrieve.
     * @return the `Team` entity if found, or `null` otherwise.
     * @throws TeamNotFoundException if the team with the specified ID is not found.
     */
    @Override
    public Team getTeamById(Long teamId){
        Team team = teamRepo.findById(teamId).orElse(null);
        if(team == null)
            throw new EntityNotFoundException("Team not found with id "+teamId);
        return team;
    }

    /**
     * Deletes a team by ID.
     *
     * @param teamId the ID of the team to delete.
     * @throws TeamNotFoundException if the team with the specified ID is not found.
     */
    @Override
    public Team deleteTeamById(Long id){
        Team obj = teamRepo.findById(id).orElse(null);
        if(obj!=null){
            teamRepo.deleteById(id);
            return obj;
        }
        return null;
    }

    public Team updateTeamById(Long teamId, Team team){
        Team repoTeam = teamRepo.findById(teamId).orElse(null);
        if(repoTeam!=null){
            if(team.getName()!=null){
                repoTeam.setName(team.getName());
            }
            if(team.getMaximumBudget()>0){
                repoTeam.setMaximumBudget(team.getMaximumBudget());
            }
            if(team.getPlayers()!=null){
                repoTeam.setPlayers(team.getPlayers());
            }
            return teamRepo.save(repoTeam);
        }else{
            throw new EntityNotFoundException("Team with ID: "+teamId+" not found");
        }
    }
}