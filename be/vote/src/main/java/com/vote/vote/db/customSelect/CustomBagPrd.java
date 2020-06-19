package com.vote.vote.db.customSelect;

public class CustomBagPrd {
    
    private int id; // 장바구니 id
    private int productId; // 상품번호
    private String name; // 상품명
    private String img; // 상품 이미지
    private int price;  // 상품가격
    private int optionId; // 옵션 id
    private String oTitle; // 옵션명
    private int oPrice; //추가가격
    private int pStock; // 재고
    private int quantity; // 개수

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getoTitle() {
        return oTitle;
    }

    public void setoTitle(String oTitle) {
        this.oTitle = oTitle;
    }

    public int getoPrice() {
        return oPrice;
    }

    public void setoPrice(int oPrice) {
        this.oPrice = oPrice;
    }

    public int getpStock() {
        return pStock;
    }

    public void setpStock(int pStock) {
        this.pStock = pStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

// select 
// p.product_id, p.p_name, p.image, p.p_price, o.option_id, o.o_title, o.o_price, o.p_stock, b.quantity
// from product p , product_option o , mybag b
// where p.product_id = o.product_id
// and p.product_id = b.product_id
// and o.option_id = b.option_id
// and b.r_id = '281'