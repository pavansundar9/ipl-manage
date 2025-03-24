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

import com.example.springapp.entity.Team;
import com.example.springapp.service.serviceImpl.TeamServiceImpl;



/**
 * Controller class for managing team-related endpoints.
 * @author PAVAN SUNDAR 10828911
 * Annotated with `@RestController` to indicate a RESTful controller.
 * Mapped to the `/api` base path using `@RequestMapping`.
 */
@RestController
@RequestMapping("/api")
public class TeamController {

    /**
     * Service for team-related operations.
     * Annotated with `@Autowired` to inject the `TeamServiceImpl` bean.
     */
    @Autowired
    private TeamServiceImpl teamServiceImpl;

    /**
     * Creates a new team.
     *
     * @param team the `Team` entity provided in the request body.
     * @return a `ResponseEntity` containing the saved `Team` entity or an error status.
     */
    @PostMapping("/team")
    public ResponseEntity<Team> createTeam(@RequestBody Team team){
        Team obj = teamServiceImpl.saveTeam(team);
        if(obj!=null)
            return ResponseEntity.status(200).body(obj);
        return ResponseEntity.status(500).body(null);
    }

    /**
     * Retrieves a team by its ID.
     *
     * @param teamId the ID of the team to retrieve.
     * @return a `ResponseEntity` containing the `Team` entity or an error status.
     */
    @GetMapping("/team/{teamId}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long teamId){
        Team obj = teamServiceImpl.getTeamById(teamId);
        if(obj!=null)
            return ResponseEntity.status(200).body(obj);
        return ResponseEntity.status(404).body(null);
    }

    @PutMapping("/team/{teamId}")
    public ResponseEntity<Team> updateTeamById(@PathVariable Long teamId, @RequestBody Team team){
        Team obj = teamServiceImpl.updateTeam(teamId, team);
        if(obj!=null)
            return ResponseEntity.status(200).body(obj);
        return ResponseEntity.status(404).body(null);
    }

    /**
     * Retrieves all teams.
     *
     * @return a `ResponseEntity` containing a list of all `Team` entities or an error status.
     */
    @GetMapping("/team")
    public ResponseEntity<List<Team>> getAllTeams(){
        List<Team> obj = teamServiceImpl.getAllTeams();
        if(obj!=null)
            return ResponseEntity.status(200).body(obj);
        return ResponseEntity.status(204).body(null);
    }

     /**
     * Deletes a team by its ID.
     *
     * @param teamId the ID of the team to delete.
     * @return a `ResponseEntity` indicating the success or failure of the operation.
     */
    @DeleteMapping("/team/{teamId}")
    public ResponseEntity<Boolean> deleteTeamById(@PathVariable Long teamId){
        Team obj = teamServiceImpl.deleteTeamById(teamId);
        if(obj!=null)
            return ResponseEntity.status(200).body(true);
        return ResponseEntity.status(404).body(false);
    }
}