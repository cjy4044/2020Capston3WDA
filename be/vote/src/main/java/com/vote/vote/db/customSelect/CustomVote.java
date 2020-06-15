package com.vote.vote.db.customSelect;

import java.util.List;

import com.vote.vote.db.dto.Vote;

public class CustomVote {
    private List<Vote> votes;
    private int count;

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}