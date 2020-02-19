package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.ByggBok;
import main.KontaktBok;
import main.Person;

class ByggBokTest {
	
	private StringBuilder sb = new StringBuilder();
	private ByggBok bb = new ByggBok();
	private KontaktBok kb = new KontaktBok();
	ArrayList<Person> lista = new ArrayList<Person>();
	Person testPerson;
	
	@BeforeEach
	void läggTillPersonIArray() {
		testPerson = new Person("Förnamn", "Efternamn", "Telefonnummer", "Mejl");
		lista.add(testPerson);
	}

	@Test
	void skapaTextTest() {
		String sb = bb.skapaText(lista).toString();
		String str = lista.get(0).getFnamn() + "," + lista.get(0).getEnamn() + "," + 
				lista.get(0).getTel()+ "," + lista.get(0).getMejl() + "\n";

		assertEquals(sb, str);
	}



}
