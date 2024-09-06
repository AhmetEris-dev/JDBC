package com.ahmete._01_JDBC_Eticaret.entity;

import java.time.LocalDate;

//POJO model -> Entity

/**
 * Entity yazımında
 * 1. fieldları tabloya bakarak yaz
 * 2. boş constructor
 * 3. id'siz constructor
 * 4. full constructor
 * 5. toString()
 * 6. getter & setter
 */
public class Musteri extends BaseEntity{
	private Integer id;
	private String ad;
	private String soyad;
	private String cinsiyet;
	private LocalDate dtarih;
	private String tel;
	private String email;
	private String sehir;
	
	// boş constructur
	public Musteri() {
	}
	
	// idsiz constructor:
	public Musteri(String ad, String soyad, String cinsiyet, LocalDate dtarih, String tel, String email, String sehir) {
		this.ad = ad;
		this.soyad = soyad;
		this.cinsiyet = cinsiyet;
		this.dtarih = dtarih;
		this.tel = tel;
		this.email = email;
		this.sehir = sehir;
	}
	
	// full constructor:
	public Musteri(String ad, String cinsiyet, LocalDate dtarih, String email, Integer id, String sehir, String soyad, String tel) {
		this.ad = ad;
		this.cinsiyet = cinsiyet;
		this.dtarih = dtarih;
		this.email = email;
		this.id = id;
		this.sehir = sehir;
		this.soyad = soyad;
		this.tel = tel;
	}
	
	public String getAd() {
		return ad;
	}
	
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	public String getCinsiyet() {
		return cinsiyet;
	}
	
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	
	public LocalDate getDtarih() {
		return dtarih;
	}
	
	public void setDtarih(LocalDate dtarih) {
		this.dtarih = dtarih;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSehir() {
		return sehir;
	}
	
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	
	public String getSoyad() {
		return soyad;
	}
	
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "Musteri{" + "ad='" + ad + '\'' + ", cinsiyet='" + cinsiyet + '\'' + ", dtarih=" + dtarih + ", email='" + email + '\'' + ", id=" + id + ", sehir='" + sehir + '\'' + ", soyad='" + soyad + '\'' + ", tel='" + tel + '\'' + ", createat=" + getCreateat() + ", state=" + getState() + ", updateat=" + getUpdateat() + '}';
	}
}