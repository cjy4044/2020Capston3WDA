package com.vote.vote.repository;

import java.util.List;

import com.vote.vote.db.customSelect.CustomPrd;
import com.vote.vote.db.customSelect.CustomPrdCategorySelect;
import com.vote.vote.db.customSelect.CustomPrdRecommend;

import org.springframework.data.domain.Pageable;

public interface CustomPrdJapRepository {
    
    public CustomPrd getManagerPrd(int manageId,Pageable page);

    public CustomPrdCategorySelect getCategorySelect(int number);

    public List<CustomPrdRecommend> getRecommendPrd(int start, int end);
}