package com.vote.vote.repository;

import java.util.List;

import com.vote.vote.db.dto.Member;

public interface MemberRepository {
    List<Member> getInfo(int a);
}