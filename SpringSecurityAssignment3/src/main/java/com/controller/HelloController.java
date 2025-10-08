package com.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.util.JwtUtil;

import io.jsonwebtoken.Jwt;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@GetMapping("/generateAdmin")
	public ResponseEntity<?> generateAdminToken(@RequestParam String username) {
		String token = JwtUtil.generateToken(username,List.of("ADMIN"));
		return ResponseEntity.ok("Bearer " + token);
	}
	
	@GetMapping("/generateUser")
	public ResponseEntity<?> generateUserToken(@RequestParam String username){
		String token = JwtUtil.generateToken(username, List.of("USER"));
		return ResponseEntity.ok("Bearer " + token);
	}
	
	
	@GetMapping("/hello")
	public ResponseEntity<?> hello(Authentication auth) {
		
		try {
			String username = auth.getName();
			return ResponseEntity.ok("Hello, " + username + "! Your token is valid.");
			
		}
		catch(Exception e) {
			return ResponseEntity.status(401).body("Invalid or expired token");
		}
	}
	
	@GetMapping("/admin")
	public ResponseEntity<?> admin(Authentication auth) {
		try {
			String username = auth.getName();
			return ResponseEntity.ok("Hello, " + username + "! Your token is valid.");
			
		}
		catch(Exception e) {
			return ResponseEntity.status(401).body("Invalid or expired token");
		}
	}
}
