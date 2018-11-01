package com.eagleshing.miniprogram.domain;

public class Bus {
	
	private int busId;
	
	private int busStationId;
	
	private String busNum;
	
	private String startStation;
	
	private String endStation;
	
	private String startTime;
	
	private String endTime;

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public int getBusStationId() {
		return busStationId;
	}

	public void setBusStationId(int busStationId) {
		this.busStationId = busStationId;
	}

	public String getBusNum() {
		return busNum;
	}

	public void setBusNum(String busNum) {
		this.busNum = busNum;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	

}
