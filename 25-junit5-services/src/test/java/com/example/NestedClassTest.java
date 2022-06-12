package com.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedClassTest {

	@Test
	void method() {
		System.out.println("Outer Class");
	}

	@Nested
	class InnerClass {
		@Test
		void method2() {
			System.out.println("Inner Class Test");
		}
	}

}
