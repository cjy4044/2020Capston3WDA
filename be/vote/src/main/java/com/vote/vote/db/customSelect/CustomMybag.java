package com.vote.vote.db.customSelect;

import java.util.List;

import com.vote.vote.db.dto.Mybag;

public class CustomMybag {
    private List<Mybag> mybags;
    private int count;

    public List<Mybag> getMybags() {
        return mybags;
    }

    public void setMybags(List<Mybag> mybags) {
        this.mybags = mybags;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}