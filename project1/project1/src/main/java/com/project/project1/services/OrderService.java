package com.project.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.project1.entities.Order;
import com.project.project1.repositories.OrderRepository;

@Service //Need to register this so the other class knows this is a service, component or other type
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	public Order findByID(Long id)
	{
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
