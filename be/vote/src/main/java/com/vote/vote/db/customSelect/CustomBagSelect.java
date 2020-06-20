package com.vote.vote.db.customSelect;

import java.util.List;

public class CustomBagSelect {
    private List<CustomBagPrd> prds;
    private int count;

    public List<CustomBagPrd> getPrds() {
        return prds;
    }

    public void setPrds(List<CustomBagPrd> prds) {
        this.prds = prds;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}