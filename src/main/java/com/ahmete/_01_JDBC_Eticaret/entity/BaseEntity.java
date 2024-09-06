package com.ahmete._01_JDBC_Eticaret.entity;

public class BaseEntity {
	private Integer state;
	private Long createat;
	private Long updateat;
	
	public Long getCreateat() {
		return createat;
	}
	
	public void setCreateat(Long createat) {
		this.createat = createat;
	}
	
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Long getUpdateat() {
		return updateat;
	}
	
	public void setUpdateat(Long updateat) {
		this.updateat = updateat;
	}
}