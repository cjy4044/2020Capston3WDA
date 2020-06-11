package com.vote.vote.db.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_category_d")
public class PrdCategoryD {
    // @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VOTE_SEQ_GENERATOR")
    // @SequenceGenerator(name="VOTE_SEQ_GENERATOR", sequenceName="VOTE_SEQ", allocationSize = 1)
    
    @Id
    @Column(nullable = false)
    private int category_d_id;
    @Column(nullable = false)
    private String category_d;
    @Column(nullable = true)
    private int category;

    public int getCategory_d_id() {
        return this.category_d_id;
    }

    public void setCategory_d_id(int category_d_id) {
        this.category_d_id = category_d_id;
    }

    public String getCategory_d() {
        return this.category_d;
    }

    public void setCategory_d(String category_d) {
        this.category_d = category_d;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}