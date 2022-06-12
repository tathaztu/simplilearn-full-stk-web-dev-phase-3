package com.simplilearn.workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()).httpBasic();
		return httpSecurity.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails userDetails =
				User
					.withDefaultPasswordEncoder()
					.username("admin")
					.password("OMGPassword!")
					.roles("USER")
					.build();

		return new InMemoryUserDetailsManager(userDetails);
	}
}
