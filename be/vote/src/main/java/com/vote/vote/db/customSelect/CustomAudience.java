package com.vote.vote.db.customSelect;

import java.util.List;

import com.vote.vote.db.dto.Audience;

public class CustomAudience {
    private List<Audience> audiences;
    private int count;
    
	public List<Audience> getAudiences() {
		return audiences;
	}
	public void setAudiences(List<Audience> audiences) {
		this.audiences = audiences;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

    
}