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
	private ByggBok bb;
	ArrayList<Person> testLista = new ArrayList<Person>();
	Person testPerson;
	
	@BeforeEach
	void läggTillPersonIArray() {
		testPerson = new Person("Förnamn", "Efternamn", "Telefonnummer", "Mejl");
		testLista.add(testPerson);
	}

//	@Test
//	void skapaTextTest() {
//		System.out.println(bb.skapaText(testLista));
//		StringBuilder strbr = new StringBuilder();
////		strbr.append(testLista.get(0).getFnamn() + "," + testLista.get(0).getEnamn() + "," + 
////				testLista.get(0).getMejl()+ "," + testLista.get(0).getTel() + "\n");
//		assertEquals(bb.skapaText(testLista), strbr);
//	}



}
