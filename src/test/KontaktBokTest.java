package test;

import static org.junit.jupiter.api.Assertions.*;

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
		konBok.visa(0);

	}

}
