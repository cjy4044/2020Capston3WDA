package com.vote.vote.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vote.vote.db.customSelect.CustomVote;
import com.vote.vote.db.dto.QVote;
import com.vote.vote.db.dto.QVoter;
import com.vote.vote.db.dto.Vote;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;




// @Transactional(readOnly = true)
@Repository
public class CustomVoteRepositoryImpl extends QuerydslRepositorySupport implements CustomVoteRepository{

    @PersistenceContext
    private EntityManager em;

    private QVote vote = QVote.vote;
    private QVoter voter = QVoter.voter;

    private Long count = 0L;

    public CustomVoteRepositoryImpl(){
        super(Vote.class);
    }

    @Override
    public CustomVote customFindVotes(String time, Pageable page, int state, int program, String text){//시간
        JPAQueryFactory query = new JPAQueryFactory(em);


        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if (state == -1){
            System.out.println("전체 투표");
        }// 투표 목록 선택 안했으면,
        else if(state == 0){//시작전 투표
            System.out.println("시작 전 투표");
            booleanBuilder.and(vote.startTime.gt(time));// 시작시간 > 현재시간
        }
        else if(state == 2){// 마감된 투표
            System.out.println("마감된 투표");
            booleanBuilder.and(vote.endTime.loe(time)); // 종료시간 =< 현재시간
        }
        else{// state == 1
            System.out.println("현재 투표 투표");
            booleanBuilder.and(vote.startTime.loe(time)).and(vote.endTime.gt(time));
        }

        if(program == 0){
            System.out.println("전체 프로그램");
        }else{
            System.out.println(program+" 번 프로그램의 투표");
            booleanBuilder.and(vote.programId.eq(program));
        }

        if(text != " "){// 검색어가 있는 경우..
            booleanBuilder.and(vote.title.contains(text));
        }

        
        List<Vote> voteList =  query.select(vote).from(vote).offset(page.getOffset()).limit(page.getPageSize()).orderBy(vote.id.desc()).where(booleanBuilder).fetch();

        Long count = query.select(vote).from(vote).where(booleanBuilder).fetchCount();
    
        
        CustomVote cv = new CustomVote();
        cv.setVotes(voteList);
        cv.setCount(count.intValue());
       
        return cv;
        
    }
    @Override
    public CustomVote getVotesByR_id(Pageable page, int r_id){
        JPAQueryFactory query = new JPAQueryFactory(em);


        BooleanBuilder booleanBuilder = new BooleanBuilder();

        

        booleanBuilder.and(vote.id.in((
            JPAExpressions
                    .select(voter.voteId)
                    .from(voter)
                    .where(voter.memberId.eq(r_id)))));

        List<Vote> voteList =  query.select(vote).from(vote).offset(page.getOffset()).limit(page.getPageSize()).orderBy(vote.id.desc()).where(booleanBuilder).fetch();
        Long count = query.select(vote).from(vote).where(booleanBuilder).fetchCount();


        CustomVote cv = new CustomVote();
        cv.setVotes(voteList);
        cv.setCount(count.intValue());
        return cv;
    }


    @Override
    public CustomVote getMyVotes(Pageable page, int r_id){

        System.out.println("아이디: "+r_id);
        JPAQueryFactory query = new JPAQueryFactory(em);


        BooleanBuilder booleanBuilder = new BooleanBuilder();

        booleanBuilder.and(vote.memberId.eq(r_id));


        List<Vote> voteList =  query.select(vote).from(vote).offset(page.getOffset()).limit(page.getPageSize()).orderBy(vote.id.desc()).where(booleanBuilder).fetch();
        Long count = query.select(vote).from(vote).where(booleanBuilder).fetchCount();        
        // System.out.println(" 개수 :"+voteList);
        CustomVote cv = new CustomVote();
        cv.setVotes(voteList);
        cv.setCount(count.intValue());


        return cv;
    }
    
    
}