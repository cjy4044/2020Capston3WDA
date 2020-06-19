package com.vote.vote.repository;

import java.util.List;

import com.vote.vote.db.dto.Mybag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MybagJpaRepository extends JpaRepository<Mybag, Integer> {
    public List<Mybag> findByUserId(int r_id);
}