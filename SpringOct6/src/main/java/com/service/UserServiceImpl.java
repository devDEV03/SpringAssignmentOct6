package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
		
	@Autowired
	private UserRepository userRepo;
	
	public String getUserNameById(Long id) {
		return userRepo.findById(id).map((n) -> n.getUsername()).orElse("Unknown");
	}

}
