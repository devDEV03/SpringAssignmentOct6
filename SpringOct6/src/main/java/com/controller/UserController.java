package com.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.repository.UserRepository;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	public UserRepository userRepo;

	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id){
		return   userRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}
