package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTest {

	@Test
	@EnabledOnOs(OS.WINDOWS)
	@DisplayName("Test on Windows")
	void method1() {
		System.out.println("Windows");
	}

	@Test
	@EnabledOnOs(OS.LINUX)
	@DisplayName("Test on Linux")
	void method2() {
		System.out.println("Linux");
	}
}
