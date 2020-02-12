package main;

public class Main {

	public static void main(String[] args) {
		
		Ui ui = new Ui();
		ui.skapaUI();
		
		
		KontaktBok kb = new KontaktBok();
		Fil fil = new Fil();
		ByggBok bb = new ByggBok();
		StringBuilder x = new StringBuilder();
		
		kb.läggTill("Louise", "Awesome", "1234545", "louise@awesome.com");
		kb.läggTill("Linn", "Fabulous", "2345566", "linn@fabulous.se");
		kb.läggTill("Oscar", "BadAss", "2457757", "oscar@badass.org");
		
//		for(Person p : kb.getKontaktLista()) {
//			System.out.println(p.getFnamn() + " " + p.getEnamn() + " " + p.getMejl() + " " + p.getTel());
//		}
		
		x = bb.skapaText(kb.getKontaktLista());
		
		fil.skapaFil(x);

	}
}
