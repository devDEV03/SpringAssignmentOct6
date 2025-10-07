package com;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.controller.UserController;
import com.entity.User;
import com.repository.UserRepository;

@WebMvcTest(UserController.class)
public class UserControllerTest2 {
	
	@Autowired
	private MockMvc mockmvc;

	@MockBean
	private UserRepository userRepo;
	
	
	@Test
	void shouldReturnUser_whenExists() throws Exception {
		when(userRepo.findById(1L)).thenReturn(Optional.of(new User(1L,"Alice")));
	
		mockmvc.perform(get("/users/1")).andExpect(status().isOk()).andExpect(jsonPath("$.username").value("Alice"));
	}
}
