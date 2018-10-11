package com.eagleshing.miniprogram.domain;

import java.util.Set;

public class UserCollectionResponse {
	
	int userId;
	
	String nickName;
	
	boolean gender;
	
	String openId;
	
	Set<CoverResponse> covers;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Set<CoverResponse> getCovers() {
		return covers;
	}

	public void setCovers(Set<CoverResponse> covers) {
		this.covers = covers;
	}
	
	
}
