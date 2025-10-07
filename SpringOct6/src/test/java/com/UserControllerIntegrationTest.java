package com;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.entity.User;
import com.repository.UserRepository;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	@Autowired
	private UserRepository userRepo;

	@BeforeEach
	void setup() {
		userRepo.deleteAll();
        User alice = new User(null, "Alice");
        userRepo.save(alice);
		
	}
	
	@Test
	void shouldReturnUserFromDatabase()throws Exception {
		 // Find the saved user ID
        User savedUser = userRepo.findAll().get(0);
        // Perform GET request
        mockmvc.perform(get("/users/" + savedUser.getUserid()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userid").value(savedUser.getUserid()))
                .andExpect(jsonPath("$.username").value("Alice"));
	}
	
	
	@Test
	void shouldReturnNotFoundForMissingUser() throws Exception{
		mockmvc.perform(get("/users/99")).andExpect(status().isNotFound());
		
	}
}
