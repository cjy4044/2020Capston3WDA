package com.vote.vote.repository;

import com.vote.vote.db.customSelect.CustomPrd;

import org.springframework.data.domain.Pageable;

public interface CustomPrdJapRepository {
    
    public CustomPrd getManagerPrd(int manageId,Pageable page);
}