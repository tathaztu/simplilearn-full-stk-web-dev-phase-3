package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

public class DynamicTest {

	@TestFactory
	Collection<org.junit.jupiter.api.DynamicTest> testCollections() {
		return Arrays.asList(
			dynamicTest("Test1", ()-> assertTrue(true)),
			dynamicTest("Executeble class", new MyExecutable())
		);
	}
}

class MyExecutable implements Executable {

	@Override
	public void execute() throws Throwable {
		System.out.println("Hello World");

	}

}
