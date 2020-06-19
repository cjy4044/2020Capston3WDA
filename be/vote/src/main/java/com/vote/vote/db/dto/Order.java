package com.vote.vote.db.dto;


import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;


@DynamicInsert
@Entity
@Table(name = "R_ORDER")
public class Order {

    @Id
    @Column(name="ORDER_ID",nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="R_ORDER_SEQ_GENERATOR")
    @SequenceGenerator(name="R_ORDER_SEQ_GENERATOR", sequenceName="R_ORDER_SEQ", allocationSize = 1)
    private int orderId;
    
    @Column(name="R_ID",nullable = true)
    private int rId;

    @Column(nullable = true)
    private String receiver;

    @Column(nullable = false)
    private String addr;

    @Column(nullable = true)
    private String addr2;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = true)
    private String invoice;

    @Column(nullable = true)
    private String orderDate;

    @Column(nullable = true)
    private String state;

    @Column(nullable = true)
    private int price;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}