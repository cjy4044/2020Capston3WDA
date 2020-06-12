package com.vote.vote.db.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "a_detail")
public class ADetail {
    
    @Id
    @Column(nullable = false, name="detail_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="A_DETAIL_SEQ_GENERATOR")
    @SequenceGenerator(name="A_DETAIL_SEQ_GENERATOR", sequenceName="A_DETAIL_SEQ", allocationSize = 1)
    private int detailId;
    
    @Column(nullable = false, name = "apply_id")
    private int applyId;
    
    @Column(nullable = false, name="r_id")
    private int rId;


    @Column(nullable = true, name="confirm")
    private String confirm;


    public String getConfirm() {
        return this.confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
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

    // @EmbeddedId  복합키 직렬화
    // private ADetaiId ADetaiId;
    // public ADetaiId getADetaiId() {
    //     return this.ADetaiId;
    // }
    // public void setADetaiId(ADetaiId ADetaiId) {
    //     this.ADetaiId = ADetaiId;
    // }
}