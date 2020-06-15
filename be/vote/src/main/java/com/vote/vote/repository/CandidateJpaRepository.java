package com.vote.vote.repository;

import java.util.ArrayList;
import java.util.List;

import com.vote.vote.db.dto.Candidate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateJpaRepository extends JpaRepository<Candidate,String>{
    // public Vote findByMemberId(String memberId);
    public List<Candidate> findByVoteId(int id);

    public ArrayList<Candidate> findAll();
}