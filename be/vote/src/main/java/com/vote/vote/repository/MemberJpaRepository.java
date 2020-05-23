package com.vote.vote.repository;

import java.util.ArrayList;

import com.vote.vote.db.dto.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long>{
    public Member findByUserid(String userid);
    public ArrayList<Member> findAll();
    
    //public ArrayList<Member> findAll(pageable);
    
}