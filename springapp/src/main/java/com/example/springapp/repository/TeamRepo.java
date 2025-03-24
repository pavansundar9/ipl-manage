package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.entity.Team;

/**
 * @author PAVAN SUNDAR 10828911
 * Repository interface for managing `Team` entity operations.
 * 
 * Extends `JpaRepository` to inherit basic CRUD and JPA-specific operations.
 */
public interface TeamRepo extends JpaRepository<Team, Long>{
    
}