package com.vote.vote.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vote.vote.db.customSelect.CustomPrd;
import com.vote.vote.db.dto.Prd;
import com.vote.vote.db.dto.QPrd;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class CustomPrdJapRepositoryImpl implements CustomPrdJapRepository {

    @PersistenceContext
    private EntityManager em;

    private QPrd prd = QPrd.prd;


    @Override
    public CustomPrd getManagerPrd(int manageId, Pageable page) {

        JPAQueryFactory query = new JPAQueryFactory(em);

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        
        booleanBuilder.and(prd.P_MANAGER.eq(manageId));

        List<Prd> prdList  = query.select(prd).from(prd)
        .offset(page.getOffset())
        .limit(page.getPageSize())
        .orderBy(prd.PRODUCTID.desc())
        .where(booleanBuilder).fetch();  

        long count =  query.select(prd).from(prd).where(booleanBuilder).fetchCount();  

        CustomPrd prds = new CustomPrd();
        prds.setPrds(prdList);
        prds.setCount((int)count);
        
        return prds;
    }
    

}
    