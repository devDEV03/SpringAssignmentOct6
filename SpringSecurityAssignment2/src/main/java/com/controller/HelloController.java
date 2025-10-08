package com.controller;

import java.net.Authenticator;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String username){
		
		String token = JwtUtil.generateToken(username);
		return ResponseEntity.ok("Bearer: " + token);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<?> hello(Authentication authentication){
		try {
			String username = authentication.getName();
			return ResponseEntity.ok("Hello, " + username + "! Your token is valid.");
			
		}
		catch(Exception e) {
			return ResponseEntity.status(401).body("Invalid or expired token");
		}
	}
}
