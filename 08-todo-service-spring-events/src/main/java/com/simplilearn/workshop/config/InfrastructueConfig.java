package com.simplilearn.workshop.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class InfrastructueConfig {

	// Use Java Based Configuration when you are writing you are writing your own code
	// Database Configuration
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/studentdb?useSSL=false&allowPublicKeyRetrieval=true");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("Welcome1");

		return driverManagerDataSource;
	}
}
