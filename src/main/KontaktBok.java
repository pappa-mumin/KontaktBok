package main;

import java.util.ArrayList;

public class KontaktBok {
		
		ArrayList<Person> KontaktLista = new ArrayList<Person>();
		
	
		public Person visa(int i) {
			return KontaktLista.get(i);
		}
		
		public Person taBort(int i) {
			return KontaktLista.remove(i);
		}
}