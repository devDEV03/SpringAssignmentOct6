package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	
	@PostMapping
	public ResponseEntity<String> register(@Valid @RequestBody UserRequest userReq){
		return ResponseEntity.ok("Registered " + userReq.getName());
	}
}
