package com.ahmete._02_JDBC_Forum.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Post extends BaseEntity{
	//Entity kısmında Post(id,userId,baslik,icerik,paylasimTarihi)
	private int id;
	private int userId;
	private String baslik;
	private String icerik;
	private LocalDate paylasimTarihi;
	
	public Post() {
	}
	
	public Post(int userId, String baslik, String icerik, LocalDate paylasimTarihi) {
		this.userId = userId;
		this.baslik = baslik;
		this.icerik = icerik;
		this.paylasimTarihi = LocalDate.now();
	}
	
	public Post(int id, int userId, String baslik, String icerik, LocalDate paylasimTarihi) {
		this.id = id;
		this.userId = userId;
		this.baslik = baslik;
		this.icerik = icerik;
		this.paylasimTarihi = LocalDate.now();
	}
	
	public Post(int id, int userId, String baslik, String icerik, LocalDate paylasimTarihi, Integer state, Long createat, Long updateat) {
		super(state, createat, updateat);
		this.id = id;
		this.userId = userId;
		this.baslik = baslik;
		this.icerik = icerik;
		this.paylasimTarihi = LocalDate.now();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getBaslik() {
		return baslik;
	}
	
	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}
	
	public String getIcerik() {
		return icerik;
	}
	
	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}
	
	public LocalDate getPaylasimTarihi() {
		return paylasimTarihi;
	}
	
	public void setPaylasimTarihi(LocalDate paylasimTarihi) {
		this.paylasimTarihi = paylasimTarihi;
	}
	
	@Override
	public String toString() {
		return "Post{" + "id=" + getId() + ", userId=" + getUserId() + ", baslik='" + getBaslik() + '\'' + ", icerik='" + getIcerik() + '\'' + ", paylasimTarihi=" + getPaylasimTarihi() + ", state=" + getState() + ", createat=" + getCreateat() + ", updateat=" + getUpdateat() + '}';
	}
}