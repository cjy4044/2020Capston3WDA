package com.vote.vote.db.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product_image")
public class PrdImage {

    @Id
    @Column(name="p_img_no",nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_IMAGE_SEQ_GENERATOR")
    @SequenceGenerator(name="PRODUCT_IMAGE_SEQ_GENERATOR", sequenceName="PRODUCT_IMAGE_SEQ", allocationSize = 1)
    private int no;

    @Column(name="product_id",nullable = false)
    private int productId;

    @Column(name="product_image",nullable = false)
    private String productImage;

    @Column(name="image_state",nullable = false)
    private String imageState;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getImageState() {
        return imageState;
    }

    public void setImageState(String imageState) {
        this.imageState = imageState;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}