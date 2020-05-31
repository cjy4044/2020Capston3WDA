package com.vote.vote.repository;

import com.vote.vote.db.dto.PrdCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrdCateJpaRepository extends JpaRepository<PrdCategory, Long> {
   
}