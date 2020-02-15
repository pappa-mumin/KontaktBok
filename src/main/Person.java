package main;

public class Person {
	
	private String fnamn, enamn, tel, mejl;

	// klassen skapad av Linn
	
	public Person(String fnamn, String enamn, String tel, String mejl) {
		super();
		this.fnamn = fnamn;
		this.enamn = enamn;
		this.tel = tel;
		this.mejl = mejl;
	}

	public String getFnamn() {
		return fnamn;
	}

	public void setFnamn(String fnamn) {
		this.fnamn = fnamn;
	}

	public String getEnamn() {
		return enamn;
	}

	public void setEnamn(String enamn) {
		this.enamn = enamn;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMejl() {
		return mejl;
	}

	public void setMejl(String mejl) {
		this.mejl = mejl;
	}
	
	
}
