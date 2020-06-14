package com.vote.vote.db.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "p_size")
public class PrdSize {


    @Id
    @Column(name="size_id",nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="P_SIZE_SEQ_GENERATOR")
    @SequenceGenerator(name="P_SIZE_SEQ_GENERATOR", sequenceName="P_SIZE_SEQ", allocationSize = 1)
    private int sizeId;

    @Column(name="p_size",nullable = false)
    private String pSize;

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getpSize() {
        return pSize;
    }

    public void setpSize(String pSize) {
        this.pSize = pSize;
    }
}