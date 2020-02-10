package main;

import java.io.File;

public class Fil {
	
	private String filNamn = "Kontaktbok/src/main/Kontaktlista.txt";
	private File fil;
	
	
	/**
	 * finnsFilen() testar om filen Kontaktlista.txt finns eller inte
	 * @return true om filen redan är skapad, false om filen inte finns
	 * @author Louise
	 */
	boolean finnsFilen(String filNamn) {
		this.filNamn = filNamn;
		File x = new File(filNamn);
		boolean finns = x.exists();
		return finns;
	}


	public String getFilNamn() {
		return filNamn;
	}
	
	public void setFilNamn(String filNamn) {
		this.filNamn = filNamn;
	}
	
	public File getFil() {
		return fil;
	}


	/**
	 * skapaFil() skapar en ny fil.
	 * @author Louise
	 */
	public void skapaFil(String filNamn) {
		this.filNamn = filNamn;
		fil = new File(filNamn);
	}
	
}
