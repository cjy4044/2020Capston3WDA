package com.vote.vote.repository;

import java.util.List;

import com.vote.vote.db.dto.PrdOption;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrdOptionJpaRepository extends JpaRepository<PrdOption, Integer> {

    List<PrdOption> findByProductIdOrderByOptionIdAsc(int p_id);
    
}