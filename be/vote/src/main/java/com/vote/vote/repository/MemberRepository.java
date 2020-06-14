package com.vote.vote.repository;

import java.util.List;

import com.vote.vote.db.dto.ADetail;
import com.vote.vote.db.dto.Member;

public interface MemberRepository {
   public List<Member> getInfo();
   public List<Member> getInfo2(int no);
}