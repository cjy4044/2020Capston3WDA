package com.vote.vote.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vote.vote.db.customSelect.CustomPrd;
import com.vote.vote.db.customSelect.CustomPrdCategorySelect;
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

        booleanBuilder.and(prd.manager.eq(manageId));

        List<Prd> prdList = query.select(prd).from(prd).offset(page.getOffset()).limit(page.getPageSize())
                .orderBy(prd.productId.desc()).where(booleanBuilder).fetch();

        long count = query.select(prd).from(prd).where(booleanBuilder).fetchCount();

        CustomPrd prds = new CustomPrd();
        prds.setPrds(prdList);
        prds.setCount((int) count);

        return prds;
    }

    @Override
    public CustomPrdCategorySelect getCategorySelect(int number) {
        
        CustomPrdCategorySelect prds = new CustomPrdCategorySelect();

        prds.setAccessory(getCategoryItem(number, 1));
        prds.setClothing(getCategoryItem(number, 2));
        prds.setDailySup(getCategoryItem(number, 3));
        prds.setFashion(getCategoryItem(number, 4));
        prds.setTapestry(getCategoryItem(number, 5));
        prds.setEtc(getCategoryItem(number, 6));

        return prds;
    }
    public List<Prd> getCategoryItem(int limit, int categoryId){
        JPAQueryFactory query = new JPAQueryFactory(em);
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        booleanBuilder.and(prd.categoryId.eq(categoryId));

    
        

        List<Prd> prdList = query.select(prd).from(prd).limit(limit)
                .orderBy(prd.productId.desc()).where(booleanBuilder).fetch();
        return prdList;
    }

}
    