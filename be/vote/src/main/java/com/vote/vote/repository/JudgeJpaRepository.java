package com.vote.vote.repository;

import com.vote.vote.db.dto.Judge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JudgeJpaRepository extends JpaRepository<Judge, String> {

    public Judge findByRid(int id);
    
}