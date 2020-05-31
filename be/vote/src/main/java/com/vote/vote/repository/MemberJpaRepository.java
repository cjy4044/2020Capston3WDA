package com.vote.vote.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import com.vote.vote.db.dto.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberJpaRepository extends JpaRepository<Member,String>{
    public Member findByUserid(String userid);
    public ArrayList<Member> findAll();
    
    @Modifying
    @Transactional
    @Query("update Member set userpw = :password, username = :name, gender = :gender, birth = :birth,"
    		+ "nickname = :nickname, addr = :addr, addr2 = :addr2 , profile = :profile where r_id = :rid ")
    void userUpdate(@Param("password") String password,
    						 @Param("name") String name,
    						 @Param("gender") String gender,
    						 @Param("birth") String birth,
    						 @Param("nickname") String nickname,
    						 @Param("addr") String addr,
    						 @Param("addr2") String addr2,
    						 @Param("profile") String profile,
    						 @Param("rid") int rid);
    
    @Modifying
    @Transactional
    @Query("update Member set userpw = :password, username = :name, gender = :gender, birth = :birth,"
    		+ "nickname = :nickname, addr = :addr, addr2 = :addr2  where r_id = :rid ")
    void kakaoUpdate(@Param("password") String password,
    						 @Param("name") String name,
    						 @Param("gender") String gender,
    						 @Param("birth") String birth,
    						 @Param("nickname") String nickname,
    						 @Param("addr") String addr,
    						 @Param("addr2") String addr2,
    						 @Param("rid") int rid);
    
   
}