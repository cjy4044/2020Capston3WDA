package com.vote.vote.repository;

import java.util.ArrayList;
import java.util.List;

import com.vote.vote.db.dto.Vote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

public interface VoteJpaRepository extends JpaRepository<Vote,String>{
    // public Vote findByMemberId(String memberId);
    public Vote findById(int id);
    public ArrayList<Vote> findAll();

    @Query(value = "select * from vote where voteid in (select voteid from voter where r_id = :userid)", nativeQuery = true)
    public ArrayList<Vote> findVotesByUserId( @Param("userid") int userid);
}