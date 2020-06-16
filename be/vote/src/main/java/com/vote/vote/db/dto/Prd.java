package com.vote.vote.db.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;


@DynamicInsert
@Entity
@Table(name = "PRODUCT")
public class Prd {

    @Id
    @Column(name="product_id",nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_SEQ_GENERATOR")
    @SequenceGenerator(name="PRODUCT_SEQ_GENERATOR", sequenceName="PRODUCT_SEQ", allocationSize = 1)
    private int PRODUCTID;
    @Column(nullable = true)
    private int PROGRAM_ID;
    @Column(nullable = true)
    private int CATEGORY_ID;
    @Column(nullable = true)
    private String P_NAME;
    @Column(nullable = true)
    private int P_PRICE;
    @Column(nullable = true)
    private String P_CONTENT;
    @Column(nullable = true)
    private String P_DETAIL;
    @Column(nullable = true)
    private String P_UPLOAD;
    @Column(nullable = true)
    private String P_STATE;

    @Column(nullable = true)
    private String P_ENDDATE;

    @Column(nullable = true)
    private int P_MANAGER;

    @Column(nullable = true)
    private int product_category_d;
    
    @Column(nullable= true)
    private int P_STOCK;



    public int getPROGRAM_ID() {
        return this.PROGRAM_ID;
    }

    public void setPROGRAM_ID(int PROGRAM_ID) {
        this.PROGRAM_ID = PROGRAM_ID;
    }

    public int getCATEGORY_ID() {
        return this.CATEGORY_ID;
    }

    public void setCATEGORY_ID(int CATEGORY_ID) {
        this.CATEGORY_ID = CATEGORY_ID;
    }

    public String getP_NAME() {
        return this.P_NAME;
    }

    public void setP_NAME(String P_NAME) {
        this.P_NAME = P_NAME;
    }

    public int getP_PRICE() {
        return this.P_PRICE;
    }

    public void setP_PRICE(int P_PRICE) {
        this.P_PRICE = P_PRICE;
    }

    public String getP_CONTENT() {
        return this.P_CONTENT;
    }

    public void setP_CONTENT(String P_CONTENT) {
        this.P_CONTENT = P_CONTENT;
    }

    public String getP_DETAIL() {
        return this.P_DETAIL;
    }

    public void setP_DETAIL(String P_DETAIL) {
        this.P_DETAIL = P_DETAIL;
    }

    public String getP_UPLOAD() {
        return this.P_UPLOAD;
    }

    public void setP_UPLOAD(String P_UPLOAD) {
        this.P_UPLOAD = P_UPLOAD;
    }

    public String getP_STATE() {
        return this.P_STATE;
    }

    public void setP_STATE(String P_STATE) {
        this.P_STATE = P_STATE;
    }

    public String getP_ENDDATE() {
        return this.P_ENDDATE;
    }

    public void setP_ENDDATE(String P_ENDDATE) {
        this.P_ENDDATE = P_ENDDATE;
    }

    public int getP_MANAGER() {
        return this.P_MANAGER;
    }

    public void setP_MANAGER(int P_MANAGER) {
        this.P_MANAGER = P_MANAGER;
    }

    public int getProduct_category_d() {
        return product_category_d;
    }

    public void setProduct_category_d(int product_category_d) {
        this.product_category_d = product_category_d;
    }

    public int getP_STOCK() {
        return P_STOCK;
    }

    public void setP_STOCK(int p_STOCK) {
        P_STOCK = p_STOCK;
    }

    public int getPRODUCTID() {
        return PRODUCTID;
    }

    public void setPRODUCTID(int pRODUCTID) {
        PRODUCTID = pRODUCTID;
    }
}