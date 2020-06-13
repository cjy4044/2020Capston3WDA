package com.vote.vote.repository;

import com.vote.vote.db.dto.PrdSize;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrdSizeJpaRepository extends JpaRepository<PrdSize, Long>{
    
}