package com.vote.vote.repository;

import com.vote.vote.db.dto.ProgramManager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramManagerJpaRepository extends JpaRepository<ProgramManager, String> {

    public ProgramManager findById(int id);
    
}