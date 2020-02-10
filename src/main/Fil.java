package main;

import java.io.File;

public class Fil {
	
	private String filNamn = "Kontaktbok/src/main/Kontaktlista.txt";
	private File fil = new File(filNamn);
	
	
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

}
