package com.vote.vote.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vote.vote.db.customSelect.CustomAudience;
import com.vote.vote.db.dto.Audience;
import com.vote.vote.db.dto.Hotclib;
import com.vote.vote.db.dto.QAudience;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class CustomAudienceRepositoryImpl extends QuerydslRepositorySupport implements CustomAudienceRepository {

    @PersistenceContext
    private EntityManager em;

    
    private QAudience audience = QAudience.audience;

    public CustomAudienceRepositoryImpl(){
        super(Audience.class);
    }
    @Override
    public CustomAudience getProgramAudiences(int p_id, Pageable page) {
        JPAQueryFactory query = new JPAQueryFactory(em);


        BooleanBuilder booleanBuilder = new BooleanBuilder();

        booleanBuilder.and(audience.programId.eq(p_id));


        List<Audience> audiences =  query.select(audience).from(audience).offset(page.getOffset()).limit(page.getPageSize()).orderBy(audience.applyId.desc()).where(booleanBuilder).fetch();
        Long count = query.select(audience).from(audience).where(booleanBuilder).fetchCount();


        CustomAudience ca = new CustomAudience();
        ca.setAudiences(audiences);
        ca.setCount(count.intValue());

        return ca;
    }
    
}