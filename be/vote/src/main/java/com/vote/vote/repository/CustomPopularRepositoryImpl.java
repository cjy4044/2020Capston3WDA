package com.vote.vote.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vote.vote.db.dto.Popular;
import com.vote.vote.db.dto.PopularBoard;
import com.vote.vote.db.dto.Program;
import com.vote.vote.db.dto.QPopular;
import com.vote.vote.db.dto.QPopularBoard;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public class CustomPopularRepositoryImpl implements CustomPopularRepository{

    @PersistenceContext
    private EntityManager em;

    private QPopular pm = QPopular.popular;

    private long count = 0;

	@Override
	public List<Popular> findByPid(int c,Pageable pageable) {
		// TODO Auto-generated method stub
		JPAQueryFactory query = new JPAQueryFactory(em); // 실제로 쿼리 되는 문장?

        BooleanBuilder booleanBuilder = new BooleanBuilder(); //여기다가 조건절을 단다.
        
        booleanBuilder.and(pm.pid.eq(c));

        List<Popular> Popular = query.select(pm).from(pm).where(booleanBuilder).offset(pageable.getOffset()).limit(pageable.getPageSize()).where(booleanBuilder).orderBy(pm.name.asc()).fetch();  //fetch 반환값이 list다

        count = query.select(pm).from(pm).where(booleanBuilder).fetchCount();

        return Popular;
	}

	@Override
	public long CountAll() {
		// TODO Auto-generated method stub
		  return count;
	}

	@Override
	public long CountByPid(int c) {
		// TODO Auto-generated method stub
		   
        JPAQueryFactory query = new JPAQueryFactory(em);


        BooleanBuilder booleanBuilder = new BooleanBuilder();

        booleanBuilder.and(pm.pid.eq(c));


        List<Popular> popularList =  query.select(pm).from(pm).where(booleanBuilder).fetch();
        
       // System.out.println(" 개수 :"+boardList);

       return popularList.size();
	}
    
    
   



    
}