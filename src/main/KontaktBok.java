package main;

import java.util.ArrayList;

public class KontaktBok {
		LäggTillKontakt ltk = new LäggTillKontakt();
		ArrayList<Person> KontaktLista = ltk.FilTillLista();
		
	
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
		
		public int sökEfterFörNamn(String x) {
			int y = 0;
			for(int i = 0; i < KontaktLista.size(); i++) {
				String str = KontaktLista.get(i).getFnamn();
				if(str.contains(x)) {
					y++;
					System.out.println(str + KontaktLista.get(i).getEnamn() + KontaktLista.get(i).getTel() + KontaktLista.get(i).getMejl());
				} 
			} return y;
		}
		
		public int sökEfterEfterNamn(String x) {
			int y = 0;
			for(int i = 0; i < KontaktLista.size(); i++) {
				String str = KontaktLista.get(i).getEnamn();
				if(str.contains(x)) {
					System.out.println(KontaktLista.get(i).getFnamn() + str + KontaktLista.get(i).getTel() + KontaktLista.get(i).getMejl());
					y++;
				} 
			} return y;
		}
		
		public int sökEfterTelefonNummer(String x) {
			int y = 0;
			for(int i = 0; i < KontaktLista.size(); i++) {
				String str = KontaktLista.get(i).getTel();
				if(str.contains(x)) {
					y++;
					System.out.println(KontaktLista.get(i).getFnamn() + KontaktLista.get(i).getEnamn() + str + KontaktLista.get(i).getMejl());
				} 
			} return y;
		}		
		
		public int sökEfterMejl(String x) {
			int y = 0;
			for(int i = 0; i < KontaktLista.size(); i++) {
				String str = KontaktLista.get(i).getMejl();
				if(str.contains(x)) {
					y++;
					System.out.println(KontaktLista.get(i).getFnamn() + KontaktLista.get(i).getEnamn() + KontaktLista.get(i).getTel() +str);
				} 
			} return y;
		}
		
		public ArrayList<Person> getKontaktLista() {
			return KontaktLista;
		}
}