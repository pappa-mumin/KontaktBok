package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.Person;

class PersonTest {
	Person p = new Person("Test", "Person", "12345", "test@testing.nu");

	@Test
	void testGetFnamn() {
		assertTrue(p.getFnamn().equals("Test"));
	}

}
