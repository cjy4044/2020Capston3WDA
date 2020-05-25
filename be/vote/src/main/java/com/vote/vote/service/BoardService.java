package com.vote.vote.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import com.vote.vote.db.dto.Member;
import com.vote.vote.repository.MemberJpaRepository;

@Service
public class BoardService {
    private MemberJpaRepository memberRepository;

    public BoardService(MemberJpaRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Page<Member> getBoardList(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
        pageable = PageRequest.of(page, 10);

        return memberRepository.findAll(pageable);
    }
}