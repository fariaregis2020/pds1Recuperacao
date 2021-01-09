package com.iftm.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.iftm.course.entities.Category;
import com.iftm.course.entities.Order;
import com.iftm.course.entities.OrderItem;
import com.iftm.course.entities.Product;
import com.iftm.course.entities.User;
import com.iftm.course.entities.enuns.OrderStatus;
import com.iftm.course.repositories.CategoryRepository;
import com.iftm.course.repositories.OrderItemRepository;
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
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(1l, "Eletronics");
		Category cat2 = new Category(2l, "Componet");
		Category cat3 = new Category(3l, "Computery");

		/*
		 * Product p1 = new Product(null , "The Lord of the Rings" ,
		 * "Lorem ipsum dolor sit amet, consectetur." , 90.5, ""); Product p2 = new
		 * Product(null , "Smart TV" , "Nulla eu imperdiet purus. Maecenas ante." ,
		 * 2190.0, ""); Product p3 = new Product(null , "Macbook Pro" ,
		 * "Nam eleifend maximus tortor, at mollis." , 1250.0, ""); Product p4 = new
		 * Product(null , "PC Gamer" , "Donec aliquet odio ac rhoncus cursus." , 1200.0,
		 * ""); Product p5 = new Product(null , "Rails for Dummies" ,
		 * "Cras fringilla convallis sem vel faucibus." , 100.99, "");
		 */ 
		
		
		/*Gambiarra pois como o exemplo da aula não roda*/

		Product p1 = new Product();
		// p.setId(null);
		p1.setName("Produto");
		p1.setPrice(15.50);
		p1.setDescription("Descrição do produto");
		p1.setImgUrl("http://www.produto.com");

		Product p2 = new Product();
		// p.setId(null);
		p2.setName("Produto");
		p2.setPrice(15.50);
		p2.setDescription("Descrição do produto");
		p2.setImgUrl("http://www.produto.com");

		Product p3 = new Product();
		// p.setId(null);
		p3.setName("Produto");
		p3.setPrice(15.50);
		p3.setDescription("Descrição do produto");
		p3.setImgUrl("http://www.produto.com");

		Product p4 = new Product();
		// p.setId(null);
		p4.setName("Produto");
		p4.setPrice(15.50);
		p4.setDescription("Descrição do produto");
		p4.setImgUrl("http://www.produto.com");

		Product p5 = new Product();
		// p.setId(null);
		p5.setName("Produto");
		p5.setPrice(15.50);
		p5.setDescription("Descrição do produto");
		p5.setImgUrl("http://www.produto.com");
		

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User u1 = new User(1l, "Carlos", "carlos@gmail.com", "34996805000", "123d");
		User u2 = new User(2l, "kamila", "kamila@email.com", "323425648", "214577");
		User u3 = new User(3l, "Jeferson", "jeferson@email.com", "88081414", "8852858");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.valueOf(1));
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.valueOf(2));
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u3, OrderStatus.valueOf(2));

		//categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		// productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		//productRepository.saveAll(Arrays.asList(p));

		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
	}
}
