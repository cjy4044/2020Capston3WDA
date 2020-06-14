package com.vote.vote.repository;

import com.vote.vote.db.dto.PrdOption;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrdOptionJpaRepository extends JpaRepository<PrdOption, Long> {
    
}