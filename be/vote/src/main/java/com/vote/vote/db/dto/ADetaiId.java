package com.vote.vote.db.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ADetaiId implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, name = "apply_id")
    private int applyId;
    
    @Column(nullable = false, name="r_id")
    private int rId;

    public int getApplyId() {
        return this.applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public int getRId() {
        return this.rId;
    }

    public void setRId(int rId) {
        this.rId = rId;
    }
}