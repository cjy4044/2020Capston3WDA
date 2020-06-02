package com.vote.vote.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vote.vote.db.dto.Company;
import com.vote.vote.db.dto.QCompany;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class CustomCompanyRepositoryImpl implements CustomCompanyRepository {

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
    
}