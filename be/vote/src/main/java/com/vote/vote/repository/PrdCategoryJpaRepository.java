package com.vote.vote.repository;

import java.util.ArrayList;
import java.util.List;

import com.vote.vote.db.dto.PrdCategory;
import com.vote.vote.db.dto.Vote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

public interface PrdCategoryJpaRepository extends JpaRepository<PrdCategory,String>{
    
    
}