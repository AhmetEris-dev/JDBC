package com.ahmete._02_JDBC_Forum;

import com.ahmete._02_JDBC_Forum.entity.User;
import com.ahmete._02_JDBC_Forum.modules.UserModule;
import com.ahmete._02_JDBC_Forum.repository.UserRepository;

public class Runner {
	public static void main(String[] args) {
		UserModule userModule = new UserModule();
		userModule.girisEkrani();
		
//		UserRepository userRepository = new UserRepository();
//		User user1=new User("Berkay","Başol","berkayb","123456789");
//		userRepository.save(user1);
//
	}
}