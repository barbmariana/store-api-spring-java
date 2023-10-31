package com.project.project1.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.project1.entities.Category;
import com.project.project1.entities.Order;
import com.project.project1.services.CategoryService;
import com.project.project1.services.OrderService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService category;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = category.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id)
	{
		Category obj = category.findByID(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
