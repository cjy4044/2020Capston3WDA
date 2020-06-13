package com.vote.vote.repository;

import com.vote.vote.db.dto.PrdColor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrdColorJpaRepository extends JpaRepository<PrdColor, Long>{
    
}