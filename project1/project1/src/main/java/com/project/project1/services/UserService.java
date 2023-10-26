package com.project.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.project1.entities.User;
import com.project.project1.repositories.UserRepository;

@Service //Need to register this so the other class knows this is a service, component or other type
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	public User findByID(Long id)
	{
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
