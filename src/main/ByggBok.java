package main;

import java.util.ArrayList;

public class ByggBok {
	
	private StringBuilder sb = new StringBuilder();
	private KontaktBok kb = new KontaktBok();
	ArrayList<Person> lista = kb.getKontaktLista();
	
	
	/**
	 * skapaText() går igenom arrayen av personer från klassen KontaktBok och bygger en sträng som ska skrivas till filen
	 * KontaktLista.txt i klassen Fil.
	 * @return sträng med kontaktinformation
	 * @author Louise
	 */
	StringBuilder skapaText(ArrayList<Person> lista) {
		this.lista = lista;
		for(int i = 0; i < lista.size(); i++) {
			sb.append(lista.get(i).getFnamn() + "\t" + lista.get(i).getEnamn() + "\t" + 
					lista.get(i).getMejl()+ "\t" + lista.get(i).getTel() + "\n");
		}
		return sb;
	}
	
	
	
}
