package main;

import java.util.ArrayList;

public class KontaktBok {
		LäggTillKontakt ltk = new LäggTillKontakt();
		public ArrayList<Person> KontaktLista = ltk.FilTillLista();
		ArrayList<Person> SökLista = new ArrayList<Person>();
		
	
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
		
		public ArrayList sökEfterFörNamn(String x) {
			int y = 0;
			for(int i = 0; i < KontaktLista.size(); i++) {
				String str = KontaktLista.get(i).getFnamn();
				y++;
				if(str.contains(x)) {
//					System.out.println(KontaktLista.get(i).getFnamn() + str + KontaktLista.get(i).getTel() + KontaktLista.get(i).getMejl());
				SökLista.add(KontaktLista.get(i));	
				} 
			} 
			if(SökLista.isEmpty()) {
				System.out.println("Ingen kontakt hittades!");
			}
			return SökLista;
		}
		
		public ArrayList sökEfterEfterNamn(String x) {
			int y = 0;
			for(int i = 0; i < KontaktLista.size(); i++) {
				String str = KontaktLista.get(i).getEnamn();
				y++;
				if(str.contains(x)) {
//					System.out.println(KontaktLista.get(i).getFnamn() + str + KontaktLista.get(i).getTel() + KontaktLista.get(i).getMejl());
				SökLista.add(KontaktLista.get(i));	
				} 
			} 
			if(SökLista.isEmpty()) {
				System.out.println("Ingen kontakt hittades!");
			}
			return SökLista;
		}
		
		public ArrayList sökEfterTelefonNummer(String x) {
			int y = 0;
			for(int i = 0; i < KontaktLista.size(); i++) {
				String str = KontaktLista.get(i).getTel();
				y++;
				if(str.contains(x)) {
//					System.out.println(KontaktLista.get(i).getFnamn() + str + KontaktLista.get(i).getTel() + KontaktLista.get(i).getMejl());
				SökLista.add(KontaktLista.get(i));	
				} 
			} 
			if(SökLista.isEmpty()) {
				System.out.println("Ingen kontakt hittades!");
			}
			return SökLista;
		}		
		
		public ArrayList sökEfterMejl(String x) {
			int y = 0;
			for(int i = 0; i < KontaktLista.size(); i++) {
				String str = KontaktLista.get(i).getMejl();
				y++;
				if(str.contains(x)) {
//					System.out.println(KontaktLista.get(i).getFnamn() + str + KontaktLista.get(i).getTel() + KontaktLista.get(i).getMejl());
				SökLista.add(KontaktLista.get(i));	
				} 
			} 
			if(SökLista.isEmpty()) {
				System.out.println("Ingen kontakt hittades!");
			}
			return SökLista;
		}
		
		public ArrayList<Person> getKontaktLista() {
			return KontaktLista;
		}
}