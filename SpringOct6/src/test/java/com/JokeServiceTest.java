package com;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.service.JokeService;

@SpringBootTest
public class JokeServiceTest {

	@Autowired
	private JokeService jokeService;
	
	
	@Autowired
	private RestTemplate rest;
	
	private MockRestServiceServer mockServer;
	
	@BeforeEach
	void setup() {
		mockServer = MockRestServiceServer.createServer(rest);
	}
	
	@Test
	void shouldReturnMockedJoke() {
	mockServer.expect(requestTo("https://api.chucknorris.io/jokes/random")).andRespond(withSuccess("{\"value\":\"Funny joke\"}",MediaType.APPLICATION_JSON));
	String result = jokeService.getJoke();	
	assertTrue(result.contains("Funny joke"));
	}
}
