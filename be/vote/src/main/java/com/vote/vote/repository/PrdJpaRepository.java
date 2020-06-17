package com.vote.vote.repository;

import com.vote.vote.db.dto.Prd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrdJpaRepository extends JpaRepository<Prd, Integer>{
    public Prd findByProductId(int p_id);
    
}