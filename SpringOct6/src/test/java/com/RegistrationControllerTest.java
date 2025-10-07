package com;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.controller.RegistrationController;

@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

	@Autowired
	private MockMvc mockmvc;
	
	
	@Test
	void shouldFailValidation_whenAgeTooLow() throws Exception{
		String json = "{\"name\":\"Tom\",\"age\":12}";
		
		mockmvc.perform(post("/register")
		.contentType(MediaType.APPLICATION_JSON)
		.content(json))
		.andExpect(status().isBadRequest());
	}
}
