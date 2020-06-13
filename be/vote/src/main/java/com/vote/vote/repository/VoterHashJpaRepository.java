package com.vote.vote.repository;

import java.util.List;

import com.vote.vote.db.dto.VoterHash;

import org.springframework.data.jpa.repository.JpaRepository;



public interface VoterHashJpaRepository extends JpaRepository<VoterHash, String> {

    List<VoterHash> findByMemberIdAndVoteId(int memberId, int voteId);
    
}