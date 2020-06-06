package com.vote.vote.repository;


import java.util.ArrayList;

import com.vote.vote.db.dto.Hotclib;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotclibRepository extends JpaRepository<Hotclib, Integer>{
  public ArrayList<Hotclib> findAll();
  public Hotclib findById(int hotclibid);
  public Hotclib deleteById(int hotclibid);
  public ArrayList<Hotclib> findByHtitle(String keyword);

} 