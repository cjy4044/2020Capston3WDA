package com.vote.vote.repository;

import com.vote.vote.db.customSelect.CustomMybag;

import org.springframework.data.domain.Pageable;

public interface CustomMybagRepository {
    public CustomMybag getMybag(int r_id, Pageable page);
}