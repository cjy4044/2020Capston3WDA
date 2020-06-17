package com.vote.vote.db.customSelect;

import java.util.List;

import com.vote.vote.db.dto.Hotclib;

public class CustomHotclib {
    private List<Hotclib> hotclips;
    private int count;

    public List<Hotclib> getHotclips() {
        return hotclips;
    }

    public void setHotclips(List<Hotclib> hotclips) {
        this.hotclips = hotclips;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}