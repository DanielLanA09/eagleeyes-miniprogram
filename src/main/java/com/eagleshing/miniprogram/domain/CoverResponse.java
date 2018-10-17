package com.eagleshing.miniprogram.domain;

import java.util.Set;

public class CoverResponse {
	
	private int coverId;
	
	private String address;
	
	private String des;
	
	private String district;
	
	private String img;
	
	private String longitude;
	
	private String latitude;
	
	private int price;
	
	private String project;
	
	private String title;
	
	private int transmitC;
	
	private int viewC;
	
	private String devName;
	
	private int mark;
	
	private float distance;

	private Set<TagResponse> tags;

	public int getCoverId() {
		return coverId;
	}
	public void setCoverId(int coverId){
		this.coverId = coverId;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTransmitC() {
		return transmitC;
	}

	public void setTransmitC(int transmitC) {
		this.transmitC = transmitC;
	}

	public int getViewC() {
		return viewC;
	}

	public void setViewC(int viewC) {
		this.viewC = viewC;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public Set<TagResponse> getTags() {
		return tags;
	}

	public void setTags(Set<TagResponse> tags) {
		this.tags = tags;
	}

	
	
	
}
