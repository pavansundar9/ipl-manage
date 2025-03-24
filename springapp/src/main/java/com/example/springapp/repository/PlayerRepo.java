package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.entity.Player;


/**
 * @author PAVAN SUNDAR 10828911
 * Repository interface for managing `Player` entity operations.
 * 
 * Extends `JpaRepository` to inherit basic CRUD and JPA-specific operations.
 */
public interface PlayerRepo extends JpaRepository<Player, Long> {

    /**
     * Finds all players based on their sold status.
     *
     * @param b the sold status (`true` for sold, `false` for unsold).
     * @return a list of `Player` entities matching the sold status.
     */
    List<Player> findBySold(boolean b); 
    List<Player> findByTeamId(Long teamId);
}