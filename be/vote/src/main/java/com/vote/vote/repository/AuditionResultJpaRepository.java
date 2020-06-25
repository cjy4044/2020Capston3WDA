package com.vote.vote.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vote.vote.db.dto.AuditionResult;

@Repository
public interface AuditionResultJpaRepository extends JpaRepository<AuditionResult, String>{
	public ArrayList<AuditionResult> findAll();
	public AuditionResult findByResultid(int resultid);
	public ArrayList<AuditionResult> findByRtitle(String keyword);
	public AuditionResult findByRfile(String rfile);
}

