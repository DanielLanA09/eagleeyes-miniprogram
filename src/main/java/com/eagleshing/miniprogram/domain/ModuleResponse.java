package com.eagleshing.miniprogram.domain;

public class ModuleResponse {
	private int cId;
	
	private int mId;
	
	private String branch;
	
	private String mName;
	
	private String mDes;
	
	private String jsonContent;
	
	private int mSort;
	
	private byte mStatus;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmDes() {
		return mDes;
	}

	public void setmDes(String mDes) {
		this.mDes = mDes;
	}

	public String getJsonContent() {
		return jsonContent;
	}

	public void setJsonContent(String jsonContent) {
		this.jsonContent = jsonContent;
	}

	public int getmSort() {
		return mSort;
	}

	public void setmSort(int mSort) {
		this.mSort = mSort;
	}

	public byte getmStatus() {
		return mStatus;
	}

	public void setmStatus(byte mStatus) {
		this.mStatus = mStatus;
	}
	
	
}
