package com.example.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SimpleLogic implements InitializingBean {

	public SimpleLogic() {
		System.out.println("Class was created");
	}

	@PostConstruct
	public void init() {
		System.out.println("Class was initialized");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Class was initialized in afterPropertiesSet()");
	}

	@PreDestroy
	public void destroyed() {
		System.out.println("Bean about to be destroyed");
	}

	public void doSimpleWork() {
		System.out.println("Work from simple logic");
	};
}
