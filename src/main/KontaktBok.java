package main;

import java.util.ArrayList;

public class KontaktBok {
		
		ArrayList<Person> KontaktLista = new ArrayList<Person>();
		
	
		public String visa(int i) {
			 Person ex = KontaktLista.get(i);
			return ex.getFnamn() + ex.getEnamn() + ex.getMejl() + ex.getTel();
		}
		
		public Person taBort(int i) {
			return KontaktLista.remove(i);
		}
		
		public void läggTill(String Fnamn, String Enamn, String Melj, String Tel) {
			Person x = new Person(Fnamn, Enamn, Melj, Tel);
			KontaktLista.add(x);
		}
}