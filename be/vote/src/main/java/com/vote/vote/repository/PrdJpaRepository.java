package com.vote.vote.repository;

import com.vote.vote.db.dto.EntityPrd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrdJpaRepository extends JpaRepository<EntityPrd, String>{
    
}