package com.vote.vote.repository;

import java.util.ArrayList;
import java.util.List;

import com.vote.vote.db.dto.PrdCategoryD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrdCateDJpaRepository extends JpaRepository<PrdCategoryD, Long> {
   ArrayList<PrdCategoryD> findAllByCategory(int category);
   ArrayList<PrdCategoryD> findCategory_dByCategory(int category);
}