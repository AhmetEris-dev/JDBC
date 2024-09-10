package com.ahmete._01_JDBC_Eticaret;

import com.ahmete._01_JDBC_Eticaret.entity.Adres;
import com.ahmete._01_JDBC_Eticaret.entity.Musteri;
import com.ahmete._01_JDBC_Eticaret.repository.AdresRepository;
import com.ahmete._01_JDBC_Eticaret.repository.MusteriRepository;

import java.time.LocalDate;
import java.util.Optional;

public class Runner {
	public static void main(String[] args) {
//		Musteri m1=new Musteri("Selim", "Sarı", "E", LocalDate.of(2000,5,15),"1236547890","selimsarigmail.com","Istanbul");
		MusteriRepository musteriRepository=new MusteriRepository();
//		musteriRepository.save(m1);
		
//		musteriRepository.delete(1000);
		
//		musteriRepository.findAll().forEach(System.out::println);
		
//		musteriRepository.findById(1002).ifPresent(System.out::println);
//		musteriRepository.findById(1999).ifPresentOrElse(System.out::println,()-> System.out.println("aradıgınız idli musteri bulunamadı"));
		
		// 1002 id'li musterinin soy adını değiştirelim
//		Optional<Musteri> gencellenecekMusteri = musteriRepository.findById(1002);
//		if(gencellenecekMusteri.isPresent()){
//			gencellenecekMusteri.get().setSoyad("YeniSarı");
//		}
//		musteriRepository.update(gencellenecekMusteri.get());
//
		musteriRepository.findById(133333).ifPresentOrElse(System.out::println,()-> System.out.println("aradıgınız " +
				                                                                                              "idli" +
				                                                                                             " musteri bulunamadı"));
		
		//public Adres(Integer musteri_id, String il, String ilce, String mahalle, String adres) {
		AdresRepository adresRepository=new AdresRepository();
//		Adres ad1=new Adres(999,"Kocaeli","İzmit","guzelbahce","15");
//		adresRepository.save(ad1);
		
//		adresRepository.delete(1022);
		
//		adresRepository.findAll().forEach(System.out::println);
		
//		adresRepository.findById(30000).ifPresent(System.out::println);
		
		
	}
}