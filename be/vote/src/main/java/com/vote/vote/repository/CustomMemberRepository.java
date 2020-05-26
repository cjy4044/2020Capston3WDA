package com.vote.vote.repository;

import java.util.List;

import com.vote.vote.db.dto.Member;

import org.springframework.data.domain.Pageable;

public interface CustomMemberRepository {
    

    public List<Member> findAll(Pageable pageable);

    public long CountAll();

}