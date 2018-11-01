package com.eagleshing.miniprogram.domain;

import java.util.Set;

public class BusStation {

	private int id;
	
	private String stationName;
	
	private Set<Bus> bus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Set<Bus> getBus() {
		return bus;
	}

	public void setBus(Set<Bus> bus) {
		this.bus = bus;
	}
}
