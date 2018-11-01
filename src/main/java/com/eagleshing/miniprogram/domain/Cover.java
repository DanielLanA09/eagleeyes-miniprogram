package com.eagleshing.miniprogram.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="cover")
public class Cover {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name="view_c")
	private int viewC;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getViewC() {
		return viewC;
	}

	public void setViewC(int viewC) {
		this.viewC = viewC;
	}
	
	
}
