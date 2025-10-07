package com;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.controller.DemoController;

@WebMvcTest(DemoController.class)
public class GlobalExceptionHandlerTest {

	@Autowired
	private MockMvc mockmvc;

	@Test
	void shouldReturnNotFoundForMissingUser() throws Exception{
		mockmvc.perform(get("/api/find/1"))
		.andExpect(status().isNotFound())
		.andExpect(content().string("User not found"));
	}
}
