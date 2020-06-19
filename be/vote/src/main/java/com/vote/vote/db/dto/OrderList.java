package com.vote.vote.db.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERLIST")
public class OrderList {

    @Id
    @Column(name="orderlist_id",nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDERLIST_SEQ_GENERATOR")
    @SequenceGenerator(name="ORDERLIST_SEQ_GENERATOR", sequenceName="ORDERLIST_SEQ", allocationSize = 1)
    private int orderListId;

    @Column(name="option_id",nullable = true)
    private int optionId;

    @Column(name="order_id",nullable = true)
    private int orderId;

    @Column(nullable = false)
    private int count;

    @Column(nullable = false)
    private int price;


    public int getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(int orderListId) {
        this.orderListId = orderListId;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}