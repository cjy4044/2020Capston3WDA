package com.vote.vote.repository;

import java.util.ArrayList;

import com.vote.vote.db.dto.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberJpaRepository extends JpaRepository<Member, Long>{
    public Member findByUserid(String userid);
//    
//    @Query(value= "select count(*) from r_user",nativeQuery = true)
//    public long CountAll();
    
    //  select count(*) from r_user where nickname='길동';
//    @Query(value= "select count(*) from r_user where ?col = ?val",nativeQuery = true)
//    public long CountAll(@Param("col") String A ,@Param("val") String B);
     
//    public ArrayList<Member> findAllByOrderByNoAsc();
    
    public ArrayList<Member> findAll();
    
    
//    @Query(value= "SELECT *  FROM (SELECT ROW_NUMBER() OVER (ORDER BY r_id) NUM , a.* FROM r_user a ORDER BY r_id desc)  WHERE NUM BETWEEN 1 AND 10",
//    		nativeQuery= true)
//    public ArrayList<Member> haha();
    
//    public ArrayList<Member> findAll(pageable page);
    
    
    //public ArrayList<Member> findAll(pageable);
    
}