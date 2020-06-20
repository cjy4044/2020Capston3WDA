package com.vote.vote.db.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MYBAG")
public class Mybag {
    
    @Id
    @Column(name="ID",nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MYBAG_SEQ_GENERATOR")
    @SequenceGenerator(name="MYBAG_SEQ_GENERATOR", sequenceName="MYBAG_SEQ", allocationSize = 1)
    private int id;

    @Column(name="PRODUCT_ID", nullable=false)
    private int productId;

    @Column(name="R_ID", nullable=false)
    private int userId;

    @Column(name="OPTION_id", nullable=true)
    private int optionId;

    @Column(name="QUANTITY", nullable=false)
    private int quantity;//수량

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}