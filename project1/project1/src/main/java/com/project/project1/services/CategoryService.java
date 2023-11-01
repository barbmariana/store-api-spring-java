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
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	public Category findByID(Long id)
	{
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
	public Category insert(Category obj) {
		return repository.save(obj);
	}

	public Category update(Long id, Category obj)
	{
		Category entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	private void updateData(Category ent, Category obj)
	{
		ent.setName(obj.getName());
	}
	public void delete(Long id)
	{
		repository.deleteById(id);
	}
}
