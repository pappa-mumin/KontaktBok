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
			sb.append(lista.get(i).getFnamn() + "," + lista.get(i).getEnamn() + "," + 
					lista.get(i).getMejl()+ "," + lista.get(i).getTel() + "\n");
		}
		return sb;
	}
	
	
	/**
	 * pad() fyller ut strängar så de blir lika långa, för att snygga till presentationen av kontaktlistan.
	 * @param str är själva textsträngen
	 * @param strLängd är den önskade längden av strängen
	 * @param tecken är de tecken du önskar fylla upp strängen med till önskad längd
	 * @return en pad:ad sträng
	 * @author Louise
	 */
	public String pad(String str, int strLängd, char tecken)
	{
	  StringBuilder padded = new StringBuilder(str);
	  while (padded.length() < strLängd)
	  {
	    padded.append(tecken);
	  }
	  return padded.toString();
	}
	
	
}
