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

	@Column(length=20)
	private String title;
	
	@Column(name="view_c")
	private int viewC;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViewC() {
		return this.viewC;
	}

	public void setViewC(int viewC) {
		this.viewC = viewC;
	}
	
	
}
