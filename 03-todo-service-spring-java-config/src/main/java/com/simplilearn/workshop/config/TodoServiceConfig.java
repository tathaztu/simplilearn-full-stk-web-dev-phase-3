package com.simplilearn.workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simplilearn.workshop.repository.TodoRepository;
import com.simplilearn.workshop.repository.TodoRepositoryImpl;
import com.simplilearn.workshop.service.TodoService;
import com.simplilearn.workshop.service.TodoServiceImpl;

@Configuration
public class TodoServiceConfig {

	// Bean Methods
	@Bean
	public TodoRepository todoRepository() {
		TodoRepository repository = new TodoRepositoryImpl();
		return repository;
	}

	@Bean
	public TodoService todoService() {
		TodoServiceImpl todoService = new TodoServiceImpl();
		todoService.setRepositoryImpl(todoRepository());

		//TodoServiceImpl todoService = new TodoServiceImpl(todoRepository());
		//todoService.setRepositoryImpl();
		return todoService;
	}



}
