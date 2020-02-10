package main;

import java.io.File;

public class Fil {
	
	private File fil = new File("Kontaktbok/src/main/Kontaktlista.txt");
	
	
	/**
	 * finnsFilen() testar om filen Kontaktlista.txt finns eller inte
	 * @return true om filen redan är skapad, false om filen inte finns
	 * @author Louise
	 */
	boolean finnsFilen() {
		File x = new File("Kontaktbok/src/main/Kontaktlista.txt");
		boolean finns = x.exists();
		return finns;
	}

}
