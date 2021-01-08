package com.iftm.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.iftm.course.entities.Category;
import com.iftm.course.entities.Order;
import com.iftm.course.entities.User;
import com.iftm.course.entities.enuns.OrderStatus;
import com.iftm.course.repositories.CategoryRepository;
import com.iftm.course.repositories.OrderRepository;
import com.iftm.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(1l, "Carlos", "carlos@gmail.com", "34996805000", "123d");
		User u2 = new User(2l, "kamila", "kamila@email.com", "323425648", "214577");
		User u3 = new User(3l, "Jeferson", "jeferson@email.com", "88081414", "8852858");
		

	

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.valueOf(1));
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.valueOf(2));
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.valueOf(2));
		
		Category cat1 = new Category(1l,"Eletronics");
		Category cat2 = new Category(2l,"Componet");
		Category cat3 = new Category(3l,"Computery");
		
		
	
				
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));	

		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
