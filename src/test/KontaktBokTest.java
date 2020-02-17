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


	@BeforeEach
	void nyKontaktBok() {
		konBok = new KontaktBok();
	}

	@BeforeEach
	void PersonerIArrayen() {
		konBok.getKontaktLista().clear();
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
		assertTrue(konBok.getKontaktLista().isEmpty());
	}
	
	@Test
	void läggTillTest() {
		Person testPerson1 = new Person("This", "Is", "A", "testPerson");
		konBok.getKontaktLista().add(testPerson1);
		assertEquals(konBok.getKontaktLista().get(1), testPerson1);
	}
	
	@Test
	void sökEfterFörnamnTest() {
		ArrayList<Person> hjälp = new ArrayList<Person>();
		Person tp = new Person("Är ", "Mitt ","FörNamn ", "här?");
		hjälp.add(tp);
		konBok.getKontaktLista().add(tp);
		ArrayList<Person> sl = konBok.sökEfterFörNamn("Är ");
		
		assertEquals(sl.get(0), hjälp.get(0));
		
	}
	
	@Test
	void sökEfterEfternamnTest() {
		ArrayList<Person> hjälp = new ArrayList<Person>();
		Person tp = new Person("Är ", "Mitt ","FörNamn ", "här?");
		hjälp.add(tp);
		konBok.getKontaktLista().add(tp);
		ArrayList<Person> sl = konBok.sökEfterEfterNamn("Mitt ");
		
		assertEquals(sl.get(0), hjälp.get(0));
	}
	
	@Test
	void sökEfterTelefonNummerTest() {
		ArrayList<Person> hjälp = new ArrayList<Person>();
		Person tp = new Person("Är ", "Mitt ","FörNamn ", "här?");
		hjälp.add(tp);
		konBok.getKontaktLista().add(tp);
		ArrayList<Person> sl = konBok.sökEfterTelefonNummer("FörNamn ");
		
		assertEquals(sl.get(0), hjälp.get(0));
	}
	
	@Test
	void sökEfterMejlTest() {
		ArrayList<Person> hjälp = new ArrayList<Person>();
		Person tp = new Person("Är ", "Mitt ","FörNamn ", "här?");
		hjälp.add(tp);
		konBok.getKontaktLista().add(tp);
		ArrayList<Person> sl = konBok.sökEfterMejl("här?");
		
		assertEquals(sl.get(0), hjälp.get(0));
	}
	
}
