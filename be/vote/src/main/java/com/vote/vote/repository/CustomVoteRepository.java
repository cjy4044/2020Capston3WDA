package com.vote.vote.repository;

import java.util.ArrayList;
import java.util.List;

import com.vote.vote.db.dto.Vote;

import org.json.simple.JSONObject;
import org.springframework.data.domain.Pageable;

public interface CustomVoteRepository{
<<<<<<< HEAD
    List<Vote> customFindVotes(String time,Pageable page,int state,int program);
=======
    List<Vote> customFindVotes(String time, String state, Pageable page);
>>>>>>> jaeyoung

    long getFindVotesCount();
}