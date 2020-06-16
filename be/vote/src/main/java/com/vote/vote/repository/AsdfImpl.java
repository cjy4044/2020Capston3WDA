package com.vote.vote.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.vote.vote.db.dto.QPrd;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vote.vote.db.dto.Prd;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javassist.runtime.Desc;


@Repository
public class AsdfImpl extends QuerydslRepositorySupport implements Asdf  {

    public AsdfImpl(){
        super(Prd.class);
    };

    @PersistenceContext
    private EntityManager em;

    private QPrd prd = QPrd.prd;

    @Override
    public List<Prd> asdf(){
        JPAQueryFactory query = new JPAQueryFactory(em);
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        List<Prd> prd2 = query.select(prd).from(prd).offset(0).limit(6).orderBy(prd.PRODUCTID.desc()).where(booleanBuilder).fetch();
        return prd2;
    }

    
}