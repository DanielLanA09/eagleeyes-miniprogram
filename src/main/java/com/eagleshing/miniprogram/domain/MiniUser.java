package com.eagleshing.miniprogram.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class MiniUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(length=200)
	String openId;
	
	@Column(length=50)
	String nickName;
	
	@Column(length=200)
	String avatarUrl;
	
	boolean gender;
	
	@Column(length=100)
	String province;
	
	@Column(length=100)
	String city;
	
	@Column(length=20)
	String language;

	@Transient
	String session_key;

	@Column(name = "shared_times")
	int sharedTimes = 0;

	@Column(name = "remain_unlock_point")
	int remainUnlockPoint = 3;

	@Transient
	int userId;

	public MiniUser() {
	}

	public MiniUser(int id, String openId, String nickName, String avatarUrl, boolean gender, String province, String city, String language, String session_key, int sharedTimes, int remainUnlockPoint) {
		this.id = id;
		this.openId = openId;
		this.nickName = nickName;
		this.avatarUrl = avatarUrl;
		this.gender = gender;
		this.province = province;
		this.city = city;
		this.language = language;
		this.session_key = session_key;
		this.sharedTimes = sharedTimes;
		this.remainUnlockPoint = remainUnlockPoint;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return this.id;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatarUrl() {
		return this.avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public boolean isGender() {
		return this.gender;
	}

	public boolean getGender() {
		return this.gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSession_key() {
		return this.session_key;
	}

	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	public int getSharedTimes() {
		return this.sharedTimes;
	}

	public void setSharedTimes(int sharedTimes) {
		this.sharedTimes = sharedTimes;
	}

	public int getRemainUnlockPoint() {
		return this.remainUnlockPoint;
	}

	public void setRemainUnlockPoint(int remainUnlockPoint) {
		this.remainUnlockPoint = remainUnlockPoint;
	}

	public MiniUser id(int id) {
		this.id = id;
		return this;
	}

	public MiniUser openId(String openId) {
		this.openId = openId;
		return this;
	}

	public MiniUser nickName(String nickName) {
		this.nickName = nickName;
		return this;
	}

	public MiniUser avatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
		return this;
	}

	public MiniUser gender(boolean gender) {
		this.gender = gender;
		return this;
	}

	public MiniUser province(String province) {
		this.province = province;
		return this;
	}

	public MiniUser city(String city) {
		this.city = city;
		return this;
	}

	public MiniUser language(String language) {
		this.language = language;
		return this;
	}

	public MiniUser session_key(String session_key) {
		this.session_key = session_key;
		return this;
	}

	public MiniUser sharedTimes(int sharedTimes) {
		this.sharedTimes = sharedTimes;
		return this;
	}

	public MiniUser remainUnlockPoint(int remainUnlockPoint) {
		this.remainUnlockPoint = remainUnlockPoint;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof MiniUser)) {
			return false;
		}
		MiniUser miniUser = (MiniUser) o;
		return id == miniUser.id && Objects.equals(openId, miniUser.openId) && Objects.equals(nickName, miniUser.nickName) && Objects.equals(avatarUrl, miniUser.avatarUrl) && gender == miniUser.gender && Objects.equals(province, miniUser.province) && Objects.equals(city, miniUser.city) && Objects.equals(language, miniUser.language) && Objects.equals(session_key, miniUser.session_key) && sharedTimes == miniUser.sharedTimes && remainUnlockPoint == miniUser.remainUnlockPoint;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, openId, nickName, avatarUrl, gender, province, city, language, session_key, sharedTimes, remainUnlockPoint);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", openId='" + getOpenId() + "'" +
			", nickName='" + getNickName() + "'" +
			", avatarUrl='" + getAvatarUrl() + "'" +
			", gender='" + isGender() + "'" +
			", province='" + getProvince() + "'" +
			", city='" + getCity() + "'" +
			", language='" + getLanguage() + "'" +
			", session_key='" + getSession_key() + "'" +
			", sharedTimes='" + getSharedTimes() + "'" +
			", remainUnlockPoint='" + getRemainUnlockPoint() + "'" +
			"}";
	}

	
}
