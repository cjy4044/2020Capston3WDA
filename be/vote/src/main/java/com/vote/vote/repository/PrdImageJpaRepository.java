package com.vote.vote.repository;

import java.util.List;

import com.vote.vote.db.dto.PrdImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrdImageJpaRepository extends JpaRepository<PrdImage, Integer>{
    List<PrdImage> findByProductId(int p_id);

    List<PrdImage> findByProductIdAndImageState(int p_id, String state);
    
}