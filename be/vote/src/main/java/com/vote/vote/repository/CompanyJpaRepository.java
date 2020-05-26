package com.vote.vote.repository;

import java.util.ArrayList;

import com.vote.vote.db.dto.Company;
import com.vote.vote.db.dto.Voter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyJpaRepository extends JpaRepository<Company,String>{
    // public Vote findByMemberId(String memberId);
  
    public ArrayList<Company> findAll();
    
    public Company findById(int c_id);

}