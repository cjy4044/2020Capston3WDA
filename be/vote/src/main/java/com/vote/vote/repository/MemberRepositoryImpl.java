package com.vote.vote.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nimbusds.oauth2.sdk.id.Audience;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryFactory;
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
    public List<Member> getInfo(int ai) {
        // TODO Auto-generated method stub

        JPAQueryFactory query = new JPAQueryFactory(em);
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(aDetail.applyId.eq(ai));
        List<Member> list = query
        .select(Projections.fields(Member.class,
        member.name,
        member.phone
        ))
        .distinct()
        .from(member)
        .join(aDetail).on(member.no.eq(aDetail.rId))
        .where(booleanBuilder)
        .fetch();












        // booleanBuilder.and(aDetail.applyId.eq(a));
        // List<Member> list = query.select(Projections.bean(Member.class, member.name,
        // member.phone)).distinct()
        // .from(aDetail, member)
        // .where(aDetail.rId.eq(member.no), booleanBuilder)
        // .fetch();

        // List<Member> list = query
        // .select(Projections.fields(Member.class,
        // member.name,
        // member.phone))
        // .from(member)
        // .join(aDetail).on(member.no.eq(aDetail.rId))
        // .where(booleanBuilder)
        // .fetch();

        // List<Member> list = query
        // .from(Projections.fields(Member.class, member.name, member.phone))
        // .fetch();

        // QueryFactory.select(member.name, member.phone)
        // .from(member)
        // .innerJoin(member.no, aDetail)
        // .fetch();

        // return queryFactory
        // .select(Projections.fields(AcademyTeacher.class,
        // academy.name.as("academyName"),
        // teacher.name.as("teacherName")
        // ))
        // .from(academy)
        // .join(teacher).on(academy.id.eq(teacher.academyId))
        // .fetch();
        return list;
    }

    @Override
    public List<Member> getInfo2() {
        // TODO Auto-generated method stub
        JPAQueryFactory query = new JPAQueryFactory(em);
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        // List<Member> list = query.select(member.name, member.phone)
        // .from(member)
        // .innerJoin(member.no, aDetail)
        // .fetch();

        List<Member> list = query
                .select(Projections.fields(Member.class, 
                member.name.as("name"), 
                member.phone.as("p")))
                .from(member)
                .join(aDetail)
                .on(member.no.eq(aDetail.rId))
                .fetch();
        return list;
    }

    // @Override
    // public List<ADetail> test() {
    // // TODO Auto-generated method stub
    // JPAQueryFactory query = new JPAQueryFactory(em);
    // BooleanBuilder booleanBuilder = new BooleanBuilder();
    // // booleanBuilder.and(aDetail.applyId.eq(1);
    // List<ADetail> list = query.from(aDetail).where(aDetail.rId.eq(1)).fetch();
    // return ;
    // }

}