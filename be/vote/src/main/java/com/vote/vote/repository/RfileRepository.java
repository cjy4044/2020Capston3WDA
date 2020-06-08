package com.vote.vote.repository;

import java.util.ArrayList;

import com.vote.vote.db.dto.Rfile;
import com.vote.vote.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface RfileRepository extends JpaRepository<Rfile, String> {

    public ArrayList<Rfile> findByFilename(int filename);
}