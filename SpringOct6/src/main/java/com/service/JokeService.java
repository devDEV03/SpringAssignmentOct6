package com.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

	private final RestTemplate rest;
	
	
	
	public JokeService(RestTemplate rest) {
		this.rest = rest;
	}
	
	public String getJoke() {
		String response = rest.getForObject("https://api.chucknorris.io/jokes/random",
				String.class);
		return response;
	}
}
