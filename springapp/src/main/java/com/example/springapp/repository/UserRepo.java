package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.entity.User;
/**
 * @author PAVAN SUNDAR 10828911
 * Repository interface for managing `User` entity operations.
 * 
 * Extends `JpaRepository` to inherit basic CRUD and JPA-specific operations.
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long>{

    User findByUsername(String username);
    
}