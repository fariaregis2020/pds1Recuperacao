package com.iftm.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.iftm.course.entities.Category;
import com.iftm.course.entities.Order;
import com.iftm.course.entities.Product;
import com.iftm.course.entities.User;
import com.iftm.course.entities.enuns.OrderStatus;
import com.iftm.course.repositories.CategoryRepository;
import com.iftm.course.repositories.OrderRepository;
import com.iftm.course.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	

	@Override
	public void run(String... args) throws Exception {
	
		Category cat1 = new Category(1l,"Eletronics");
		Category cat2 = new Category(2l,"Componet");
		Category cat3 = new Category(3l,"Computery");
		
	
		User u1 = new User(1l, "Carlos", "carlos@gmail.com", "34996805000", "123d");
		User u2 = new User(2l, "kamila", "kamila@email.com", "323425648", "214577");
		User u3 = new User(3l, "Jeferson", "jeferson@email.com", "88081414", "8852858");
	

	   
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.valueOf(1));
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.valueOf(2));
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u3, OrderStatus.valueOf(2));
		
		
		Product p = new Product();
		//p.setId(null);
		p.setName("Produto");
		p.setPrice(15.50);
		p.setDescription("Descrição do produto");
		p.setImgUrl("http://www.produto.com");
		
		
		/*
		Product p1 = new Product(null , "The Lord of the Rings" , "Lorem ipsum dolor sit amet, consectetur." , 90.5, "");
		Product p2 = new Product(null , "Smart TV" , "Nulla eu imperdiet purus. Maecenas ante." , 2190.0, "");
		Product p3 = new Product(null , "Macbook Pro" , "Nam eleifend maximus tortor, at mollis." , 1250.0, "");
		Product p4 = new Product(null , "PC Gamer" , "Donec aliquet odio ac rhoncus cursus." , 1200.0, "");
		Product p5 = new Product(null , "Rails for Dummies" , "Cras fringilla convallis sem vel faucibus." , 100.99, "");
		*/
	
				
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		//productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		productRepository.saveAll(Arrays.asList(p));



		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
