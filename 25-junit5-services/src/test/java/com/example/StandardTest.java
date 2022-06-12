package com.example;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Standard Test")
public class StandardTest {

	@Test
	@Disabled("This is disabled")
	void skip() {

	}

	@BeforeAll
	public static void initAll() {
		System.out.println("Before all the test methods!");
	}

	@BeforeEach
	public void init() {
		System.out.println("Before each of the test methods!");
	}


	@Test
	void failingTest() {
		System.out.println("Failing Test");
		fail("Always fails");
	}

	@Test
	void succeedingTest() {
		System.out.println("Succeeding Test");
	}

	@AfterEach
	void tearDown() {
		System.out.println("After each of the test methods!");
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("After all the test methods!");
	}
}
