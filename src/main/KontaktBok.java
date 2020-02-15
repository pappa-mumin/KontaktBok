package main;

import java.util.ArrayList;

public class KontaktBok {
		LäggTillKontakt ltk = new LäggTillKontakt();
		public ArrayList<Person> KontaktLista = ltk.FilTillLista();
		ArrayList<Person> SökLista = new ArrayList<Person>();
		
		/**
		 * visa() skapar en sträng av ett person-objekt från kontaktlistan.
		 * @param i anger vilket index i arrayen av personer som ska presenteras som sträng
		 * @return ger en sträng med personens data
		 * @author Oscar
		 */
		public String visa(int i) {
			 Person ex = KontaktLista.get(i);
			return ex.getFnamn() +" "+ ex.getEnamn() +" "+ ex.getTel() +" "+ ex.getMejl();
		}
		
		/**
		 * taBort() tar bort ett objekt ur personarraylistan kontaktlista
		 * @param i anger indexet för objektet som ska raderas
		 * @return 
		 * @author Oscar
		 */
		public Person taBort(int i) {
			return KontaktLista.remove(i);
		}
		
		/** 
		 * läggTill() lägger till ett person-objekt i arraylistan kontaktlista
		 * @param Fnamn är personens förnamn
		 * @param Enamn är personens efternamn
		 * @param Tel är personens telefonnummer
		 * @param Mejl är personens mejladress
		 * @author Oscar
		 */
		public void läggTill(String Fnamn, String Enamn, String Tel, String Mejl) {
			Person x = new Person(Fnamn, Enamn, Tel, Mejl);
			KontaktLista.add(x);
		}
		
		public ArrayList<Person> sökEfterFörNamn(String x) {
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
		
		public ArrayList<Person> sökEfterEfterNamn(String x) {
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
		
		public ArrayList<Person> sökEfterTelefonNummer(String x) {
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
		
		public ArrayList<Person> sökEfterMejl(String x) {
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