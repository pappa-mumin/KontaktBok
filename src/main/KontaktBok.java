package main;

import java.util.ArrayList;

public class KontaktBok {
		
		ArrayList<Person> KontaktLista = new ArrayList<Person>();
		
	
		public String visa(int i) {
			 Person ex = KontaktLista.get(i);
			return ex.getFnamn() +" "+ ex.getEnamn() +" "+ ex.getTel() +" "+ ex.getMejl();
		}
		
		public Person taBort(int i) {
			return KontaktLista.remove(i);
		}
		
		public void läggTill(String Fnamn, String Enamn, String Tel, String Mejl) {
			Person x = new Person(Fnamn, Enamn, Tel, Mejl);
			KontaktLista.add(x);
		}
		
		public ArrayList<Person> getKontaktLista() {
			return KontaktLista;
		}
}