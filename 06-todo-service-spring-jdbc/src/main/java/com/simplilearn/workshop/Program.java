package com.simplilearn.workshop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simplilearn.workshop.config.TodoServiceConfig;
import com.simplilearn.workshop.service.TodoService;
import com.simplilearn.workshop.service.TodoServiceImpl;

public class Program {

   public static void main(String[] args) {

	   // create and configure beans
	   // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	   ApplicationContext context = new AnnotationConfigApplicationContext(TodoServiceConfig.class);
	   TodoService theTodoService = context.getBean("todoService", TodoServiceImpl.class);

       // System.out.println(theTodoService.findAll().get(0).getDescription());
	   System.out.println("The number of Todos is :" + theTodoService.getTodosCount());

	   System.out.println("Find by id  =  2 :" + theTodoService.findById(2l).getDescription());


    }
}
