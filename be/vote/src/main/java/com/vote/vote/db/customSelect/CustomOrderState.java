package com.vote.vote.db.customSelect;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.math.BigDecimal;
// @SqlResultSetMapping(
//         name="orderStateMapping",
//         classes = @ConstructorResult(
//             targetClass = CustomOrderState.class,
//             columns ={
//                 @ColumnResult(name="product_id", type = Integer.class),
//                 @ColumnResult(name="name", type = String.class),
//                 @ColumnResult(name="sum", type = Integer.class),
//                 @ColumnResult(name="one", type = Integer.class),
//                 @ColumnResult(name="two", type = Integer.class),
//                 @ColumnResult(name="three", type = Integer.class),
//                 @ColumnResult(name="four", type = Integer.class),
//                 @ColumnResult(name="five", type = Integer.class)
//             }
//         )
//     )
public class CustomOrderState {
    private int product_id;
    private String name;
    private int sum;
    private int one;
    private int two;
    private int three;
    private int four;
    private int five;
    private String image;




    
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public int getThree() {
        return three;
    }

    public void setThree(int three) {
        this.three = three;
    }

    public int getFour() {
        return four;
    }

    public void setFour(int four) {
        this.four = four;
    }

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public CustomOrderState(BigDecimal product_id, String name,String image , BigDecimal sum, BigDecimal one, BigDecimal two, BigDecimal three, BigDecimal four, BigDecimal five) {
        this.product_id = product_id.intValue();
        this.image = image;
        this.name = name;
        this.sum = sum.intValue();
        this.one = one.intValue();
        this.two = two.intValue();
        this.three = three.intValue();
        this.four = four.intValue();
        this.five = five.intValue();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}