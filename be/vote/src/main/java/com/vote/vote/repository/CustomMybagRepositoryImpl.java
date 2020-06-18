package com.vote.vote.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vote.vote.db.customSelect.CustomBagPrd;
import com.vote.vote.db.customSelect.CustomMybag;
import com.vote.vote.db.dto.QMybag;
import com.vote.vote.db.dto.QPrd;
import com.vote.vote.db.dto.QPrdImage;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class CustomMybagRepositoryImpl implements CustomMybagRepository {

    @PersistenceContext
    private EntityManager em;

    private QMybag mybag = QMybag.mybag;

    private QPrd prd = QPrd.prd;
    private QPrdImage img = QPrdImage.prdImage;

    @Override
    public CustomMybag getMybag(int r_id, Pageable page) {

        JPAQueryFactory query = new JPAQueryFactory(em); // 실제로 쿼리 되는 문장?

        BooleanBuilder booleanBuilder = new BooleanBuilder(); //여기다가 조건절을 단다.
        booleanBuilder.and(
            prd.productId.in(
                JPAExpressions.select(mybag.productId)
                                .from(mybag)
                                .where(mybag.userId.eq(r_id))
                            )
                        );

        // List<Mybag> mybags = query.select(mybag).from(mybag).offset(page.getOffset()).limit(page.getPageSize()).where(booleanBuilder).fetch();  //fetch 반환값이 list다

        query.select(Projections.fields(CustomBagPrd.class, prd,img))
        .from(prd)
        .join(img).on(prd.productId.eq(img.productId))
        .where(booleanBuilder)
        .fetch();

        // Long count = query.select(mybag).from(mybag).where(booleanBuilder).fetchCount();

        // CustomMybag result = new CustomMybag();
        // result.setMybags(mybags);
        // result.setCount(count.intValue());

        return null;
    }
    
    
}