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
import com.vote.vote.db.dto.Company;
import com.vote.vote.db.dto.QCompany;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class CustomCompanyRepositoryImpl implements CustomCompanyRepository{

    @PersistenceContext
    private EntityManager em;

    private QCompany cm = QCompany.company;

    private long count = 0;
    
    
    @Override
    public List<Company> findAll(Pageable pageable) {
        
        JPAQueryFactory query = new JPAQueryFactory(em); // 실제로 쿼리 되는 문장?

        BooleanBuilder booleanBuilder = new BooleanBuilder(); //여기다가 조건절을 단다.

        List<Company> company = query.select(cm).from(cm).offset(pageable.getOffset()).limit(pageable.getPageSize()).where(booleanBuilder).fetch();  //fetch 반환값이 list다

        count = query.select(cm).from(cm).where(booleanBuilder).fetchCount();

        return company;
    }

    @Override
    public long CountAll() {
    	
        	
        return count;
    }

	@Override
	public Company findByConfirm(int c) {
		
		JPAQueryFactory query = new JPAQueryFactory(em); // 실제로 쿼리 되는 문장?
    	
    	BooleanBuilder booleanBuilder = new BooleanBuilder();//여기다가 조건절을 단다.
    	
    	booleanBuilder.and(cm.id.eq(c));
//    	
    	Company company = query.select(cm).from(cm).where(booleanBuilder).fetchOne();  //fetchOne = Company  Fetch = List<Company>

    	
		
		
		return company;
	}

	@Override
	public void updateByConfirm(int c) {
		

		JPAQueryFactory query = new JPAQueryFactory(em); // 실제로 쿼리 되는 문장?
    	
//    	BooleanBuilder booleanBuilder = new BooleanBuilder();//여기다가 조건절을 단다.
//    	
//    	booleanBuilder.and(cm.id.eq(c));
    	
       query.update(cm).where(cm.id.eq(c)).set(cm.cconfirm, "1").execute();
    	


	}

    
}