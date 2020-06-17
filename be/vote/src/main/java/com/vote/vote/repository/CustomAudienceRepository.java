package com.vote.vote.repository;

import com.vote.vote.db.customSelect.CustomAudience;

import org.springframework.data.domain.Pageable;



public interface CustomAudienceRepository {
    CustomAudience getProgramAudiences(int p_id, Pageable page);
}