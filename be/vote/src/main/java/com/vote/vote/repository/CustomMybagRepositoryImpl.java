package com.vote.vote.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vote.vote.db.customSelect.CustomBagPrd;
import com.vote.vote.db.customSelect.CustomBagSelect;
import com.vote.vote.db.customSelect.CustomMybag;
import com.vote.vote.db.dto.QMybag;
import com.vote.vote.db.dto.QPrd;
import com.vote.vote.db.dto.QPrdOption;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class CustomMybagRepositoryImpl implements CustomMybagRepository {

    @PersistenceContext
    private EntityManager em;

    private QMybag mybag = QMybag.mybag;

    private QPrd prd = QPrd.prd;
    private QPrdOption option = QPrdOption.prdOption;

    @Override
    public CustomBagSelect getMybag(int r_id, Pageable page) {

        JPAQueryFactory query = new JPAQueryFactory(em); // 실제로 쿼리 되는 문장?

        BooleanBuilder booleanBuilder = new BooleanBuilder(); //여기다가 조건절을 단다.


        booleanBuilder.and(option.optionId.eq(mybag.optionId));
        booleanBuilder.and(mybag.userId.eq(r_id));


        List<CustomBagPrd> mybagPrds = 

        query.select(Projections.bean(CustomBagPrd.class, 
            mybag.id,
            prd.productId,
            prd.name,
            prd.img,
            prd.price,
            option.optionId,
            option.oTitle,
            option.oPrice,
            option.pStock,
            mybag.quantity
        ))
        .from(prd)
        .join(option).on(prd.productId.eq(option.productId))
        .join(mybag).on(prd.productId.eq(mybag.productId))
        .where(booleanBuilder)
        .offset(page.getOffset()).limit(page.getPageSize())
        .orderBy(mybag.id.desc())
        .fetch();

        Long count = 
            query.select(Projections.bean(CustomBagPrd.class, 
                mybag.id,
                prd.productId,
                prd.name,
                prd.img,
                prd.price,
                option.optionId,
                option.oTitle,
                option.oPrice,
                option.pStock,
                mybag.quantity
            ))
            .from(prd)
            .join(option).on(prd.productId.eq(option.productId))
            .join(mybag).on(prd.productId.eq(mybag.productId))
            .where(booleanBuilder)
            .fetchCount();

        CustomBagSelect result = new CustomBagSelect();
        result.setPrds(mybagPrds);
        result.setCount(count.intValue());

        return result;
    }
    
    
}