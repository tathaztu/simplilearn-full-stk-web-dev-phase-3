package com.example.demo;

import org.springframework.beans.factory.InitializingBean;

public class PlainSimpleLogic implements InitializingBean {

	// Dependency will be injected to our class upon creation of our bean
	// @Autowired

	private SimpleLogic simpleLogic;

	public PlainSimpleLogic(SimpleLogic simpleLogic) {
		System.out.println("Class was created");
		this.simpleLogic = simpleLogic;
	}

	public void init() {
		System.out.println("Class was initialized");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Class was initialized in afterPropertiesSet()");
	}

	public void destroyed() {
		System.out.println("Bean about to be destroyed");
	}

	public void doSomeWork() {
		simpleLogic.doSimpleWork();
	}
}
