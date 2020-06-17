package com.vote.vote.db.customSelect;

import java.util.List;

import com.vote.vote.db.dto.Prd;

public class CustomPrdCategorySelect {
    private List<Prd> accessory;
    private List<Prd> clothing;
    private List<Prd> dailySup;
    private List<Prd> fashion;
    private List<Prd> tapestry;
    private List<Prd> etc;

    public List<Prd> getAccessory() {
        return accessory;
    }

    public void setAccessory(List<Prd> accessory) {
        this.accessory = accessory;
    }

    public List<Prd> getClothing() {
        return clothing;
    }

    public void setClothing(List<Prd> clothing) {
        this.clothing = clothing;
    }

    public List<Prd> getDailySup() {
        return dailySup;
    }

    public void setDailySup(List<Prd> dailySup) {
        this.dailySup = dailySup;
    }

    public List<Prd> getFashion() {
        return fashion;
    }

    public void setFashion(List<Prd> fashion) {
        this.fashion = fashion;
    }

    public List<Prd> getTapestry() {
        return tapestry;
    }

    public void setTapestry(List<Prd> tapestry) {
        this.tapestry = tapestry;
    }

    public List<Prd> getEtc() {
        return etc;
    }

    public void setEtc(List<Prd> etc) {
        this.etc = etc;
    }

}