package com.vote.vote.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vote.vote.db.dto.ADetail;
import com.vote.vote.db.dto.Member;
import com.vote.vote.db.dto.QADetail;
import com.vote.vote.db.dto.QMember;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
  

    @PersistenceContext
    private EntityManager em;
    private QMember member = QMember.member;
    private QADetail aDetail = QADetail.aDetail;

    @Override
    public List<Member> getInfo(int a) {
        // TODO Auto-generated method stub

        JPAQueryFactory query = new JPAQueryFactory(em);
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(aDetail.applyId.eq(a));
        List<Member> list = query.select(Projections.bean(Member.class, member.name, member.phone)).distinct()
        .from(aDetail, member)
        .where(aDetail.rId.eq(member.no), booleanBuilder)
        .fetch();



        return list;
    }
    
}