package com.vote.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.vote.vote.db.dto.Audience;


@Repository
public interface AudienceJpaRepository extends JpaRepository<Audience, Integer>{
    public Audience findById(int applyId);
    public Audience deleteById(int applyId);
    List<Audience> findByaTitleContaining(String aTitle);
}