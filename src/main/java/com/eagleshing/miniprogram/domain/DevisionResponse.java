package com.eagleshing.miniprogram.domain;

import java.util.Set;

public class DevisionResponse {
	private int id;
	
	private int coverId;
	
	private int mark;
	
	private String devName;
	
	private String norm;
	
	private int devSort;
	
	private int devType;
	
	private String icon1;
	
	private String icon2;
	
	private String devDes;
	
	private Set<ParamsResponse> params;
	
	
	
	public String getDevDes() {
		return devDes;
	}

	public void setDevDes(String devDes) {
		this.devDes = devDes;
	}

	public String getIcon1() {
		return icon1;
	}

	public void setIcon1(String icon1) {
		this.icon1 = icon1;
	}

	public String getIcon2() {
		return icon2;
	}

	public void setIcon2(String icon2) {
		this.icon2 = icon2;
	}

	public Set<ParamsResponse> getParams() {
		return params;
	}

	public void setParams(Set<ParamsResponse> params) {
		this.params = params;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCoverId() {
		return coverId;
	}

	public void setCoverId(int coverId) {
		this.coverId = coverId;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getNorm() {
		return norm;
	}

	public void setNorm(String norm) {
		this.norm = norm;
	}

	public int getDevSort() {
		return devSort;
	}

	public void setDevSort(int devSort) {
		this.devSort = devSort;
	}

	public int getDevType() {
		return devType;
	}

	public void setDevType(int devType) {
		this.devType = devType;
	}
	
	

}
