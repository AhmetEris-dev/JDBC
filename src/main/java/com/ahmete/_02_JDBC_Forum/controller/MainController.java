package com.ahmete._02_JDBC_Forum.controller;

import com.ahmete._02_JDBC_Forum.entity.Post;
import com.ahmete._02_JDBC_Forum.entity.User;
import com.ahmete._02_JDBC_Forum.repository.PostRepository;
import com.ahmete._02_JDBC_Forum.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainController {
	private static final Scanner scanner = new Scanner(System.in);
	private final PostRepository postRepository;
	
	
	
	public MainController() {
		this.postRepository = new PostRepository();
	}
	
	public void girisEkrani(){
		Scanner scanner = new Scanner(System.in);
		
		while (true){
			System.out.println("Java15 Post Giris Menusu");
			System.out.println("1-Post Görüntüle");
			System.out.println("2-Post Paylaş");
			System.out.println("3-Kendi Postlarını Görüntüle");
			System.out.println("4-Kullanıcıları Listele");
			System.out.println("0-Cıkış yap");
			System.out.print("Seçiminiz: ");
			
			int secim = scanner.nextInt();scanner.nextLine();
			
			switch (secim){
				case 1:{
					tumPostlariGoruntule();
					break;
				}
				case 2:{
					postPaylas();
					break;
				}
				case 3:{
					kendiPostlariniGoruntule();
					break;
				}
				case 4:{
					kullanicilariListele();
					break;
				}
			}
		}
	}
	
	
	
	
	private void tumPostlariGoruntule() {
		List<Post> posts = postRepository.findAll();
		
		if (posts.isEmpty()) {
			System.out.println("Hiç post bulunmamaktadır.");
		} else {
			for (Post post : posts) {
				System.out.println("Kullanıcı: " + post.getUserId());
				System.out.println("Başlık: " + post.getBaslik());
				System.out.println("İçerik: " + post.getIcerik());
				System.out.println("Tarih: " + post.getPaylasimTarihi());
				System.out.println("-----------------------");
			}
		}
	}
	
	private void postPaylas() {
		if (UserController.girisYapanKullanici==null){
			System.out.println("Post paylaşmak için giriş yapmanız gereklidir.");
			return;
		}
		
		System.out.print("Başlık: ");
		String baslik = scanner.nextLine();
		
		System.out.print("İçerik: ");
		String icerik = scanner.nextLine();
		
		Post post =new Post(UserController.girisYapanKullanici.getId(), baslik, icerik, LocalDate.now());
		postRepository.save(post);
		
		System.out.println("Post başarıyla paylaşıldı");
	}
	
	private void kendiPostlariniGoruntule() {
		if (UserController.girisYapanKullanici == null) {
			System.out.println("Kendi postlarını görüntülemek için giriş yapmanız gerekiyor.");
			return;
		}
		
		List<Post> userPosts = postRepository.findByUserId(UserController.girisYapanKullanici.getId());
		
		if (userPosts.isEmpty()) {
			System.out.println("Hiç post paylaşmadınız.");
		} else {
			for (Post post : userPosts) {
				System.out.println("Başlık: " + post.getBaslik());
				System.out.println("İçerik: " + post.getIcerik());
				System.out.println("Tarih: " + post.getPaylasimTarihi());
				System.out.println("-----------------------");
			}
		}
		
	}
	
	private void kullanicilariListele() {
		List<User> users = new UserController().getAllUsers(); // Bu metodu UserController'dan implement edin
		
		if (users.isEmpty()) {
			System.out.println("Hiç kullanıcı bulunmuyor.");
		} else {
			System.out.println("Kullanıcı Listesi:");
			for (User user : users) {
				System.out.println("Username: " + user.getUsername());
			}
		}
	}
	
}