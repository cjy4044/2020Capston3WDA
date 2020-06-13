package com.vote.vote.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.FilteredClause;
import com.querydsl.core.dml.StoreClause;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.vote.vote.db.dto.PopularBoard;
import com.vote.vote.db.dto.QPopularBoard;
import com.vote.vote.db.dto.Vote;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class CustomPopularBoardRepositoryImpl implements CustomPopularBoardRepository{

    @PersistenceContext
    private EntityManager em;

    private QPopularBoard pm = QPopularBoard.popularBoard;

    private long count = 0;
    
    
    @Override
    public List<PopularBoard> findAll(Pageable pageable) {
        
        JPAQueryFactory query = new JPAQueryFactory(em); // 실제로 쿼리 되는 문장?

        BooleanBuilder booleanBuilder = new BooleanBuilder(); //여기다가 조건절을 단다.

        List<PopularBoard> PopularBoard = query.select(pm).from(pm).offset(pageable.getOffset()).limit(pageable.getPageSize()).where(booleanBuilder).fetch();  //fetch 반환값이 list다

        count = query.select(pm).from(pm).where(booleanBuilder).fetchCount();

        return PopularBoard;
    }
    
    @Override
    public List<PopularBoard> findById(int c,Pageable pageable) {
        
        JPAQueryFactory query = new JPAQueryFactory(em); // 실제로 쿼리 되는 문장?

        BooleanBuilder booleanBuilder = new BooleanBuilder(); //여기다가 조건절을 단다.
        
        booleanBuilder.and(pm.popularid.eq(c));

        List<PopularBoard> PopularBoard = query.select(pm).from(pm).where(booleanBuilder).offset(pageable.getOffset()).limit(pageable.getPageSize()).where(booleanBuilder).fetch();  //fetch 반환값이 list다

        count = query.select(pm).from(pm).where(booleanBuilder).fetchCount();

        return PopularBoard;
    }
    

    @Override
    public long CountAll() {
    	
        	
        return count;
    }
    

    
    @Override
    public long CountById(int c) {
    	
    	   System.out.println("아이디: "+c);
    	   
           JPAQueryFactory query = new JPAQueryFactory(em);


           BooleanBuilder booleanBuilder = new BooleanBuilder();

           booleanBuilder.and(pm.popularid.eq(c));


           List<PopularBoard> boardList =  query.select(pm).from(pm).where(booleanBuilder).fetch();
           
           System.out.println(" 개수 :"+boardList);

          return boardList.size();

    }



    
}