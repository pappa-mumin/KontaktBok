package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LäggTillKontakt {
	Fil fil = new Fil();
	
	static Scanner s, rubriker;
	static String[] radhållare;
	Person pers;
	ArrayList<Person> lista = new ArrayList<Person>();

	
	public ArrayList<Person> FilTillLista() {
	try {
		s = new Scanner( new File("KontaktLista.txt"));
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	
	String fnamn, enamn, tel, mejl;
		while(s.hasNextLine()) {
			radhållare = s.nextLine().split("\t");
			fnamn = radhållare[0];
			enamn = radhållare[1];
			tel = radhållare[2];
			mejl = radhållare[3];
	
			pers = new Person(fnamn, enamn, tel, mejl);
			lista.add(pers);	
		}	
		return lista;
	}
}
