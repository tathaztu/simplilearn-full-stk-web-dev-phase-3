package com.simplilearn.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.Todo;
import com.simplilearn.workshop.events.TodosEvent;
import com.simplilearn.workshop.repository.TodoRepository;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService, ApplicationEventPublisherAware {

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
		publisher.publishEvent(new TodosEvent(this, "FINDALL", todoRepository));
		return todoRepository.findAll();
	}

	@Override
	public Todo save(Todo theTodo) {
		publisher.publishEvent(new TodosEvent(this, "SAVE", todoRepository));
		return todoRepository.save(theTodo);
	}

	@Override
	public Todo deleteById(long theId) {
		publisher.publishEvent(new TodosEvent(this, "DELETEBYID", todoRepository));
		return todoRepository.deleteById(theId);
	}

	@Override
	public Todo findById(long theId) {
		publisher.publishEvent(new TodosEvent(this, "FINDBYID", todoRepository));
		return todoRepository.findById(theId);
	}

	private ApplicationEventPublisher publisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;

	}


}
