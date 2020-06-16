package com.vote.vote.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vote.vote.db.customSelect.CustomHotclib;
import com.vote.vote.db.dto.Hotclib;
import com.vote.vote.db.dto.QHotclib;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;


@Repository
public class CustomHotClibRepositoryImpl extends QuerydslRepositorySupport implements CustomHotClibRepository {
    @PersistenceContext
    private EntityManager em;

    
    private QHotclib hotclib = QHotclib.hotclib;

    public CustomHotClibRepositoryImpl(){
        super(Hotclib.class);
    }


    @Override
    public CustomHotclib getProgramHotclibs(int p_id, Pageable page) {
        
        JPAQueryFactory query = new JPAQueryFactory(em);


        BooleanBuilder booleanBuilder = new BooleanBuilder();

        
        booleanBuilder.and(hotclib.programid.eq(p_id));
        // booleanBuilder.and(vote.id.in((
        //     JPAExpressions
        //             .select(voter.voteId)
        //             .from(voter)
        //             .where(voter.memberId.eq(r_id)))));

        List<Hotclib> hotclibList =  query.select(hotclib).from(hotclib).offset(page.getOffset()).limit(page.getPageSize()).orderBy(hotclib.hotclibid.desc()).where(booleanBuilder).fetch();
        Long count = query.select(hotclib).from(hotclib).where(booleanBuilder).fetchCount();
        CustomHotclib ch = new CustomHotclib();
        ch.setHotclips(hotclibList);
        ch.setCount(count.intValue());
        return ch;
    }
    
}