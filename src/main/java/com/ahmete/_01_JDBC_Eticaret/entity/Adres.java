package com.ahmete._01_JDBC_Eticaret.entity;

public class Adres extends BaseEntity {
	
	private Integer id;
	private Integer musteri_id;
	private String il;
	private String ilce;
	private String mahalle;
	private String adres;
	
	public Adres() {
	}
	
	public Adres(Integer musteri_id, String il, String ilce, String mahalle, String adres) {
		this.musteri_id = musteri_id;
		this.il = il;
		this.ilce = ilce;
		this.mahalle = mahalle;
		this.adres = adres;
	}
	
	public Adres(Integer id, Integer musteri_id, String il, String ilce, String mahalle, String adres) {
		this.id = id;
		this.musteri_id = musteri_id;
		this.il = il;
		this.ilce = ilce;
		this.mahalle = mahalle;
		this.adres = adres;
	}
	
	public String getAdres() {
		return adres;
	}
	
	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getIl() {
		return il;
	}
	
	public void setIl(String il) {
		this.il = il;
	}
	
	public String getIlce() {
		return ilce;
	}
	
	public void setIlce(String ilce) {
		this.ilce = ilce;
	}
	
	public String getMahalle() {
		return mahalle;
	}
	
	public void setMahalle(String mahalle) {
		this.mahalle = mahalle;
	}
	
	public Integer getMusteri_id() {
		return musteri_id;
	}
	
	public void setMusteri_id(Integer musteri_id) {
		this.musteri_id = musteri_id;
	}
	
	@Override
	public String toString() {
		return "Adres{" + "adres='" + getAdres() + '\'' + ", id=" + getId() + ", musteri_id=" + getMusteri_id() + ", il='" + getIl() + '\'' + ", ilce='" + getIlce() + '\'' + ", mahalle='" + getMahalle() + '\'' + ", createat=" + getCreateat() + ", state=" + getState() + ", updateat=" + getUpdateat() + '}';
	}
}