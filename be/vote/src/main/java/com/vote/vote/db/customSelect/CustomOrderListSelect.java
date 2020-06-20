package com.vote.vote.db.customSelect;

import java.util.List;

public class CustomOrderListSelect {
    private List<CustomOrderList> orderList;
    private int  count;

    
	public List<CustomOrderList> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<CustomOrderList> orderList) {
		this.orderList = orderList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}