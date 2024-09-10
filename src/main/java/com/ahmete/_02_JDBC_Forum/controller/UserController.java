package com.ahmete._02_JDBC_Forum.controller;

import com.ahmete._02_JDBC_Forum.entity.User;
import com.ahmete._02_JDBC_Forum.repository.UserRepository;

import java.util.Optional;
import java.util.Scanner;

public class UserController {
	private final UserRepository userRepository;
	
	public UserController() {
		this.userRepository = new UserRepository();
	}
	
	public void girisEkrani() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Java15 Forum Giris Menu");
			System.out.println("1. Kayıt Ol");
			System.out.println("2. Giriş Yap");
			System.out.println("0. Çıkış");
			System.out.print("seciminiz: ");
			
			int secim = scanner.nextInt();
			scanner.nextLine();
			
			switch (secim) {
				case 1:
					register();
					break;
				case 2:
					login();
					break;
				case 0:
					System.out.println("Çıkış yapılıyor...");
					return;
				default:
					System.out.println("Geçersiz seçenek, lütfen tekrar deneyin.");
			}
		}
	}
	
	
	public void register() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Adınızı giriniz: ");
		String ad = scanner.nextLine();
		
		System.out.print("Soyadınızı giriniz: ");
		String soyad = scanner.nextLine();
		
		System.out.print("Username giriniz: ");
		String username = scanner.nextLine();
		
		if (userRepository.existsByUserName(username)) {
			System.out.println("Bu username zaten alınmış, lütfen başka bir username deneyin.");
			return;
		}
		
		System.out.print("Password giriniz: ");
		String password = scanner.nextLine();
		
		
		User user = new User(ad, soyad, username, password);
		userRepository.save(user);
		System.out.println("Kayıt başarıyla tamamlandı!");
	}
	
	public void login() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Username giriniz: ");
		String username = scanner.nextLine();
		
		System.out.print("Password giriniz: ");
		String password = scanner.nextLine();
		
		Optional<User> user = userRepository.doLogin(username, password);
		
		if (user.isPresent()) {
			System.out.println("Giriş başarılı! Hoşgeldiniz, " + user.get().getAd() + "!");
		
		} else {
			System.out.println("Giriş bilgileri hatalı!");
		}
	}
	
}