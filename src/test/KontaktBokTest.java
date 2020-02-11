package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.KontaktBok;
import main.Person;

class KontaktBokTest {
	
	private KontaktBok konBok;
	private Person testPerson;
	ArrayList<Person> KontaktLista = new ArrayList<Person>();

	@BeforeEach
	void nyKontaktBok() {
		konBok = new KontaktBok();
	}

	@BeforeEach
	void PersonerIArrayen() {
		testPerson = new Person("Förnamn","Efternamn", "Telefonnummer", "Melj");
		konBok.getKontaktLista().add(testPerson);
	}
	
	@Test
	void visaTest() {
		String s = testPerson.getFnamn() +" "+ testPerson.getEnamn() +" "+ testPerson.getTel() +" "+ testPerson.getMejl();
		assertEquals(konBok.visa(0), s);
	}
	
	@Test
	void taBortTest() {
		konBok.taBort(0);
		assertTrue(KontaktLista.isEmpty());
	}
	
	@Test
	void läggTillTest() {
		Person testPerson1 = new Person("This", "Is", "A", "testPerson");
		konBok.getKontaktLista().add(testPerson1);
		assertEquals(konBok.getKontaktLista().get(1), testPerson1);
	}
	

}
