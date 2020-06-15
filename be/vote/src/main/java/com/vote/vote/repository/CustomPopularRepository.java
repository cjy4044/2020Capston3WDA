package com.vote.vote.repository;

import com.vote.vote.db.dto.Popular;
import com.vote.vote.db.dto.Program;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomPopularRepository{

       
    public List<Popular> findByPid(int pid,Pageable pageable);
    
    public long CountAll();
    
    public long CountByPid(int popularid);
 
    public List<Popular> getCandidates(int ... ids);
    
}