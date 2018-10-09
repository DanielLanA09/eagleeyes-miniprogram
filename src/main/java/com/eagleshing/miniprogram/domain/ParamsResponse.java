package com.eagleshing.miniprogram.domain;

public class ParamsResponse {
	
	private int id;
	
	private String paramType;
	
	private String paramName;
	
	private String paramData;
	
	private String paramdDes;
	
	private boolean must;
	
	private int devisionId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamData() {
		return paramData;
	}

	public void setParamData(String paramData) {
		this.paramData = paramData;
	}

	public String getParamdDes() {
		return paramdDes;
	}

	public void setParamdDes(String paramdDes) {
		this.paramdDes = paramdDes;
	}

	public boolean isMust() {
		return must;
	}

	public void setMust(boolean must) {
		this.must = must;
	}

	public int getDevisionId() {
		return devisionId;
	}

	public void setDevisionId(int devisionId) {
		this.devisionId = devisionId;
	}

	
	
	
}
