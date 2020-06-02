package com.vote.vote.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.vote.vote.db.dto.Company;

public interface CustomCompanyRepository {
    

    public List<Company> findAll(Pageable pageable);

    public long CountAll();

}