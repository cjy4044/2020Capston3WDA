package com.vote.vote.db.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product_option")
public class PrdOption {
    
    @Id
    @Column(name="option_id",nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_OPTION_SEQ_GENERATOR")
    @SequenceGenerator(name="PRODUCT_OPTION_SEQ_GENERATOR", sequenceName="PRODUCT_OPTION_SEQ", allocationSize = 1)
    private int optionId;

    @Column(name="product_id",nullable = false)
    private int productId;

    @Column(name="size_id",nullable = false)
    private int sizeId;

    @Column(name="color_id",nullable = false)
    private int colorId;

    @Column(name="p_stock",nullable = false)
    private int pStock;

    @Column(name="o_price",nullable = false)
    private int oPrice;

    @Column(name="o_title",nullable = false)
    private String oTitle;

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getpStock() {
        return pStock;
    }

    public void setpStock(int pStock) {
        this.pStock = pStock;
    }

    public int getoPrice() {
        return oPrice;
    }

    public void setoPrice(int oPrice) {
        this.oPrice = oPrice;
    }

    public String getoTitle() {
        return oTitle;
    }

    public void setoTitle(String oTitle) {
        this.oTitle = oTitle;
    }
    
}