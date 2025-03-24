package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.entity.Player;
import com.example.springapp.entity.Team;
import com.example.springapp.service.serviceImpl.OrganizerServiceImpl;
import com.example.springapp.service.serviceImpl.TeamServiceImpl;


/**
 * Controller class for managing organizer-related endpoints.
 * 
 * @author PAVAN SUNDAR 10828911
 *         Annotated with `@RestController` to indicate a RESTful controller.
 *         Mapped to the `/api/organizer` base path using `@RequestMapping`.
 */

@RestController
@RequestMapping("/api/organizer")
public class OrganizerController {

    /**
     * Service implementation for organizer operations.
     * Annotated with `@Autowired` to inject the `OrganizerServiceImpl` bean.
     */
    @Autowired
    private OrganizerServiceImpl organizerServiceImpl;

    @Autowired
    private TeamServiceImpl teamServiceImpl;

    /**
     * Retrieves a list of unsold players.
     *
     * @return a `ResponseEntity` containing a list of unsold `Player` entities.
     */
    @GetMapping("/unsold-players")
    public ResponseEntity<List<Player>> getUnsoldPlayers() {
        return ResponseEntity.status(200).body(organizerServiceImpl.getUnsoldPlayers());
    }

    /**
     * Retrieves a list of sold players.
     *
     * @return a `ResponseEntity` containing a list of sold `Player` entities.
     */
    @GetMapping("/sold-players")
    public ResponseEntity<List<Player>> getSoldPlayers() {
        return ResponseEntity.status(200).body(organizerServiceImpl.getSoldPlayers());
    }

    /**
     * Assigns a player to a team.
     *
     * @param playerId the ID of the player to be assigned.
     * @param teamId   the ID of the team to assign the player to.
     * @return a `ResponseEntity` with a success message if the operation is
     *         successful, or an error message otherwise.
     */
    @PostMapping("/assign-player")
    public ResponseEntity<String> assignPlayerToTeam(@RequestParam Long playerId, @RequestParam Long teamId) {
        organizerServiceImpl.assignPlayerToTeam(playerId, teamId);

        return ResponseEntity.status(201).body("Player assigned to team successfully");
    }

    /**
     * Releases a player from their current team.
     *
     * @param id the ID of the player to be released.
     * @return a `ResponseEntity` with a success message if the operation is
     *         successful, or an error message otherwise.
     */
    @PutMapping("/release-player")
    public ResponseEntity<String> releasePlayerFromTeam(@RequestParam Long playerId) {
        organizerServiceImpl.releasePlayerFromTeam(playerId);
        return ResponseEntity.status(200).body("Player released from team successfully");
    }

    /**
     * Retrieves a list of players belonging to a specific team.
     *
     * @param id the ID of the team whose players are to be retrieved.
     * @return a `ResponseEntity` containing a list of `Player` entities.
     */

    @GetMapping("/players-list")
    public ResponseEntity<List<Player>> getPlayerListByTeamId(@RequestParam Long teamId) {
        return ResponseEntity.status(200).body(organizerServiceImpl.getPlayerListByTeamId(teamId));
    }

    @GetMapping("/team")
    public ResponseEntity<List<Team>> getTeams(){
        return ResponseEntity.status(200).body(teamServiceImpl.getAllTeams());
    }   

    // @GetMapping("/")
}