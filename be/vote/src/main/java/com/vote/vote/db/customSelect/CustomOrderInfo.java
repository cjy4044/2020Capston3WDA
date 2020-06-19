package com.vote.vote.db.customSelect;

public class CustomOrderInfo {
    // QueryDsl 에서 사용하는것이 아니라, controller 에서 사용할 DTO 임
    // 주문 페이지에서 사용할 데이터 용.
    private int id; // 상품 id
    private String name; // 상품명 
    private String img; // 상품 이미지
    private int price; // 상품가격
    private int optionId; // 옵션 아이디
    private String optionName;// 옵션명
    private int oPrice; //옵션 추가금액
    private int count; // 개수
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public int getoPrice() {
		return oPrice;
	}
	public void setoPrice(int oPrice) {
		this.oPrice = oPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}


}