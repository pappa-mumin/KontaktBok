package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Fil {
	
	private String filNamn = "KontaktLista.txt";
	StringBuilder text;
	
	
	public String getFilNamn() {
		return filNamn;
	}
	
	public void setFilNamn(String filNamn) {
		this.filNamn = filNamn;
	}
	
	/**
	 * finnsFilen() testar om filen Kontaktlista.txt finns eller inte
	 * @return true om filen redan är skapad, false om filen inte finns
	 * @author Louise
	 */
	public boolean finnsFilen(String filNamn) {
		this.filNamn = filNamn;
		File x = new File(filNamn);
		boolean finns = x.exists();
		return finns;
	}

	/**
	 * skapaFil() skapar en ny fil och skriver in kontakter i listan.
	 * @author Louise
	 */
	public void skapaFil(StringBuilder text) {
		this.text = text;
		try (PrintStream out = new PrintStream(new FileOutputStream(filNamn))){	
		out.print(text);
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		}
	}

	public StringBuilder getText() {
		return text;
	}

	public void setText(StringBuilder text) {
		this.text = text;
	}
	
	
	
}
