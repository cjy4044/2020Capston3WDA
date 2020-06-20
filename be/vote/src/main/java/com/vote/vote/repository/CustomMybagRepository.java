package com.vote.vote.repository;

import com.vote.vote.db.customSelect.CustomBagSelect;

import org.springframework.data.domain.Pageable;

public interface CustomMybagRepository {
    // public CustomBagSelect getMybag(int r_id, Pageable page);
    public CustomBagSelect getMybag(int r_id);
}