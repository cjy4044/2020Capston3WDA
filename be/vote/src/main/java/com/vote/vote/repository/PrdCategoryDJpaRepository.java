package com.vote.vote.repository;

import java.util.List;

import com.vote.vote.db.dto.PrdCategoryD;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrdCategoryDJpaRepository extends JpaRepository<PrdCategoryD,String>{
    
    List<PrdCategoryD> findByCategory(int categoryId);
}