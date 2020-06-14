package com.vote.vote.repository;

import java.util.ArrayList;
import java.util.List;

import com.vote.vote.db.dto.Rfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RfileRepository extends JpaRepository<Rfile, Integer> {
    public ArrayList<Rfile> findByHotclibid(int hotclibid);
    
    public Rfile findByFileid(int fileid);
    
    public List<Rfile> findByPid(int pid);
    
    
}