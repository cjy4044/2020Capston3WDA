package com.vote.vote.repository;

import com.vote.vote.db.customSelect.CustomHotclib;

import org.springframework.data.domain.Pageable;

public interface CustomHotClibRepository {
    CustomHotclib getProgramHotclibs(int p_id, Pageable page);
}