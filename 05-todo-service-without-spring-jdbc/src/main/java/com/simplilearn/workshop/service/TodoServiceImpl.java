package com.simplilearn.workshop.service;

import java.util.List;

import com.simplilearn.workshop.domain.Todo;
import com.simplilearn.workshop.repository.TodoRepository;
import com.simplilearn.workshop.repository.TodoRepositoryImpl;

public class TodoServiceImpl implements TodoService{

	// This is the dependency
	// Depends on TodoRepository
	TodoRepository repositoryImpl = new TodoRepositoryImpl();

	@Override
	public List<Todo> findAll() {
		return repositoryImpl.findAll();
	}

	@Override
	public Todo save(Todo theTodo) {
		return repositoryImpl.save(theTodo);
	}

	@Override
	public Todo deleteById(long theId) {
		return repositoryImpl.deleteById(theId);
	}

	@Override
	public Todo findById(long theId) {
		return repositoryImpl.findById(theId);
	}

}
