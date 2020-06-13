package com.vote.vote.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.vote.vote.db.dto.PopularBoard;

public interface CustomPopularBoardRepository {
    

    public List<PopularBoard> findAll(Pageable pageable);
    
    public List<PopularBoard> findById(int c,Pageable pageable);

    public long CountAll();
    
    public long CountById(int popularid);


}