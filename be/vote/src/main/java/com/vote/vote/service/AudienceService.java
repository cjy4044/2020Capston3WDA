package com.vote.vote.service;

import com.vote.vote.db.dto.Audience;
import com.vote.vote.db.dto.Rfile;
import com.vote.vote.repository.AudienceJpaRepository;
import com.vote.vote.repository.RfileRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AudienceService {
    private AudienceJpaRepository audienceJpaRepository;
   

    public AudienceService(AudienceJpaRepository audienceJpaRepository, RfileRepository repository){
        this.audienceJpaRepository = audienceJpaRepository;
        
    }

    public Page<Audience> getBoardList(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
      
        pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "applyId")); // <- Sort 추가
        return audienceJpaRepository.findAll(pageable);
    }

    
}