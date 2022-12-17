package com.unab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Proyecto1Application implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Proyecto1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password= "12345";
		for(int i=0; i<2; i++) {
			String bcrypassword=passwordEncoder.encode(password);
			System.out.println(bcrypassword);
		}
				
	}
	
	

}
