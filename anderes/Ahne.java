public class Ahne {

	String vorname;
	String nachname;

	char geschlecht;

	public Ahne(String pVorname, String pNachname, char pGeschlecht) {
		this.vorname = pVorname;
		this.nachname = pNachname;
		this.geschlecht = pGeschlecht;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public char getGeschlecht() {
		return geschlecht;
	}

}
