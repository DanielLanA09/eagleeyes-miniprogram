package com.eagleshing.miniprogram.payload;

public class IsCollectedRequest {
	
	int userId;
	
	int coverId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCoverId() {
		return coverId;
	}

	public void setCoverId(int coverId) {
		this.coverId = coverId;
	}
	
	
}
