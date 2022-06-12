package com.example;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AssertionsTest {

	@Test
	public void testMethod() {
		// assertTrue(4<0);
		// assertFalse(4<0);

		String s1 = null;
		// assertNull(s1);

		String s2 = "Tatha";
		// assertNotNull(s2);

		// assertSame(s1, s2);
		// assertNotSame(s1, s2);

		// assertEquals(5, 5);
		// assertNotEquals(5, 6);


		// String [] a1 = {"A", "B"};
		// String [] a2 = {"A", "B"};
		// assertArrayEquals(a1, a2);

		assertThrows(RuntimeException.class, ()->{
			throw new RuntimeException();
		});
	}
}
