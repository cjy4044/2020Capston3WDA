package com.vote.vote.repository;

import java.util.ArrayList;
import java.util.List;

import com.vote.vote.db.customSelect.CustomVote;
import com.vote.vote.db.dto.Vote;

import org.json.simple.JSONObject;
import org.springframework.data.domain.Pageable;

public interface CustomVoteRepository{
    CustomVote customFindVotes(String time,Pageable page,int state,int program, String text);

    CustomVote getVotesByR_id(Pageable page, int r_id);
    

    CustomVote getMyVotes(Pageable page, int r_id);
    
}