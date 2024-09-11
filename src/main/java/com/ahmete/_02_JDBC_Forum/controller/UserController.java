package com.ahmete._02_JDBC_Forum.controller;

import com.ahmete._02_JDBC_Forum.entity.User;
import com.ahmete._02_JDBC_Forum.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserController {
	private final UserRepository userRepository;
	public static User girisYapanKullanici;
	
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
					if (girisYapanKullanici != null) {
						MainController mainController = new MainController();
						mainController.girisEkrani();
					}
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
		
		String username;
		boolean isRegisteredUser;
		String ad,soyad;
		
		do {
			System.out.print("Adınızı giriniz: ");
			ad = scanner.nextLine();
			
			System.out.print("Soyadınızı giriniz: ");
			soyad = scanner.nextLine();
			
			System.out.print("Username giriniz: ");
			username = scanner.nextLine();
			
			isRegisteredUser = !userRepository.existsByUserName(username);
			if (!isRegisteredUser) {
				System.out.println("Bu username zaten alınmış, lütfen başka bir username deneyin.");
			}
			
		} while (!isRegisteredUser);
		
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
			girisYapanKullanici=user.get(); //girisbasarılı ise kullanıcıyı sakladık
			System.out.println("Giriş başarılı! Hoşgeldin, " + user.get().getAd() +" "+ user.get().getSoyad()+ "!");
			//burada giriş yapan user'a her yerden erişebilmeli
		
		} else {
			System.out.println("Giriş bilgileri hatalı!");
		}
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}