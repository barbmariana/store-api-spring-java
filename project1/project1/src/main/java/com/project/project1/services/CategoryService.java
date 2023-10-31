package com.project.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.project1.entities.Category;
import com.project.project1.entities.Order;
import com.project.project1.repositories.CategoryRepository;
import com.project.project1.repositories.OrderRepository;

@Service //Need to register this so the other class knows this is a service, component or other type
public class CategoryService {
	
	@Autowired
	private CategoryRepository category;
	
	public List<Category> findAll(){
		return category.findAll();
	}
	public Category findByID(Long id)
	{
		Optional<Category> obj = category.findById(id);
		return obj.get();
	}
}
