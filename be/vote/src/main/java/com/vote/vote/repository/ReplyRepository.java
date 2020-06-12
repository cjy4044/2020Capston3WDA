package com.vote.vote.repository;

import java.util.ArrayList;

import com.vote.vote.db.dto.Reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    public ArrayList<Reply> findAll();
    public ArrayList<Reply> findByHotclibid(int hotclibid);
    public Reply deleteById(int replyid);
    
    
    
}