package com.simplilearn.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.Todo;
import com.simplilearn.workshop.repository.TodoRepository;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService{

	// This is the dependency
	// Depends on TodoRepository
	// TodoRepository repositoryImpl = new TodoRepositoryImpl(); // Old Code

	@Autowired
	private TodoRepository todoRepository;
	// Autowire by name - repositoryImpl
	// Autowire by type - TodoRepository

	// Spring Default Constructor - Autowire by default
	public TodoServiceImpl() {

	}


	@Override
	public int getTodosCount() {
		return todoRepository.getTodosCount();
	}


	// DI using Constructor
	public TodoServiceImpl(TodoRepository repositoryImpl) {
		System.out.println("Spring container called this constructor to Assemble the TodoRepository bean");
		this.todoRepository = repositoryImpl;
	}

	// DI using Setter Methods
	public void setRepositoryImpl(TodoRepository repositoryImpl) {
		System.out.println("Spring container called this setter method to Assemble the TodoRepository bean");
		this.todoRepository = repositoryImpl;
	}

	@Override
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	@Override
	public Todo save(Todo theTodo) {
		return todoRepository.save(theTodo);
	}

	@Override
	public Todo deleteById(long theId) {
		return todoRepository.deleteById(theId);
	}

	@Override
	public Todo findById(long theId) {
		return todoRepository.findById(theId);
	}


}
