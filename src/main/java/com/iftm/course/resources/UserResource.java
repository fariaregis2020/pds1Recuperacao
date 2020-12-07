package com.iftm.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.course.entities.User;

@RestController
@RequestMapping(value= "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1l, "maria","maria@gmail.com", "3488585858", "123");
		return ResponseEntity.ok().body(u);
		
	}

}
