package com.vote.vote.repository;

import com.vote.vote.db.dto.PrdImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrdImageJpaRepository extends JpaRepository<PrdImage, Long>{
    
}