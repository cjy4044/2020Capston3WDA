package com.vote.vote.db.customSelect;

import java.util.List;

import com.vote.vote.db.dto.Prd;

public class CustomPrdByOption {
    private List<Prd> prds;
    private int count;

    public List<Prd> getPrds() {
        return prds;
    }

    public void setPrds(List<Prd> prds) {
        this.prds = prds;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}