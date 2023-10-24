package com.project.project1.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.project1.entities.User;
import com.project.project1.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String...args) throws Exception{
		
		User u1 = new User(null, "Mariana Barbosa", "mariana@gmail.com", "99999999", "123456");
		User u2 = new User(null, "Julia Rocha", "juliarocha@gmail.com", "988888888", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
