package com.project.project1.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.project1.entities.Category;
import com.project.project1.entities.Order;
import com.project.project1.entities.OrderItem;
import com.project.project1.entities.Payment;
import com.project.project1.entities.Product;
import com.project.project1.entities.User;
import com.project.project1.entities.enums.OrderStatus;
import com.project.project1.repositories.CategoryRepository;
import com.project.project1.repositories.OrderItemRepository;
import com.project.project1.repositories.OrderRepository;
import com.project.project1.repositories.ProductRepository;
import com.project.project1.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productsRepositories;
	
	@Autowired
	private OrderItemRepository orderItemsRepository;
	@Override
	public void run(String...args) throws Exception{
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		User u1 = new User(null, "Mariana Barbosa", "mariana@gmail.com", "99999999", "123456");
		User u2 = new User(null, "Julia Rocha", "juliarocha@gmail.com", "988888888", "123456");
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.CANCELED, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.DELIVERED, u1);
		

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productsRepositories.saveAll(Arrays.asList(p1 , p2, p3, p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		
		productsRepositories.saveAll(Arrays.asList(p1 , p2, p3, p4,p5));
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemsRepository.saveAll(Arrays.asList( oi1, oi2, oi3, oi4));
	
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1); // we dont need to call payment repository because it depends on order
		
		orderRepository.save(o1);
		
	}
}

// Class the configuration just for the test profile, we are using to seeding DB.
// We make the dependency by calling userRepository, and we need to "desacoplar" 
// and associate an instance at the class called. But spring do this for us by using 
// @Autowired