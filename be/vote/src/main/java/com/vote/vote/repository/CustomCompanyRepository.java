package com.vote.vote.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.vote.vote.db.dto.Company;

public interface CustomCompanyRepository {
    

    public List<Company> findAll(Pageable pageable);

    public long CountAll();

	public Company findByConfirm(int c);
	
	@Transactional
	public void updateByConfirm(int c);    


}