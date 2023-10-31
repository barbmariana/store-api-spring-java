package com.project.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.project1.entities.Product;
import com.project.project1.repositories.ProductRepository;

@Service //Need to register this so the other class knows this is a service, component or other type
public class ProductService {
	
	@Autowired
	private ProductRepository product;
	
	public List<Product> findAll(){
		return product.findAll();
	}
	public Product findByID(Long id)
	{
		Optional<Product> obj = product.findById(id);
		return obj.get();
	}
}
