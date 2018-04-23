package datenfelder;

public class LineareSuche {
	public static void main(String... args) {
		// Werte
		int[] weite = { 210, 190, 224, 211, 230, 225, 210, 205, 194 };
		// Namen
		String[] namen = { "Mark", "Nora", "Oliver", "Paul", "Rosa", "Saskia", "Tina", "Ufuk", "Vladimir" };
		// Durchschnitt initialisieren
		int durchschnitt = 0;
		// Durchschnitt ausrechnen
		for (int i = 0; i < weite.length; i++) {
			durchschnitt += weite[i];
		}
		durchschnitt /= weite.length;
		// Index deklarieren
		int index = -1;
		// Lineare Suche
		for (int i = 0; i < weite.length; i++) {
			if (weite[i] == durchschnitt) {
				index = i;
				break;
			}
		}
		// Ausgabe
		System.out.println("Durchschnitt: " + durchschnitt + "cm");
		System.out.println("Spieler mit Durchschnitt: " + (index == -1 ? "/" : namen[index]));
	}
}
