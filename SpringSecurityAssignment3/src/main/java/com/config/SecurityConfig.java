package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.security.CustomAccessDeniedHandler;
import com.security.JwtRequestFilter;

@Configuration
public class SecurityConfig {

	private final JwtRequestFilter jwtRequestFilter;
	private final CustomAccessDeniedHandler accessDeniedHandler;

	public SecurityConfig(JwtRequestFilter jwtRequestFilter, CustomAccessDeniedHandler accessDeniedHandler) {
		this.jwtRequestFilter = jwtRequestFilter;
		this.accessDeniedHandler = accessDeniedHandler;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/api/hello").hasRole("ADMIN")
						.requestMatchers("/api/admin").authenticated().anyRequest().permitAll())
				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
				.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler)).build();
	}
}
