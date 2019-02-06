package zweidarrays;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Random;

public class ZweiDArrays {

	static String[][] tabelle = null;

	public static void main(String... args) {
		Random random = new Random();
		// String[][] januarKalender = new String[31][24];
		int anzahlZeilen = 2;
		int anzahlSpalten = 3;

		tabelle = new String[anzahlZeilen][anzahlSpalten];

		int dims = anzahlZeilen * anzahlSpalten; // besser anzahlZellen

		System.out.println("Dimension: " + dims); // besser anzahlZellen

		// Ausgabe der Array Länge
		System.out.println("Länge des Arrays: " + tabelle.length);

		// Ausgabe der Länge des 0. Elements
		System.out.println("0. Element: " + tabelle[0].length);

		// Tabelle füllen
		for (int x = 0; x < anzahlZeilen; x++) {
			for (int y = 0; y < anzahlSpalten; y++) {
				tabelle[x][y] = Double.toString(random.nextDouble());
			}
		}

		System.out.println(Arrays.deepToString(tabelle)); // kann auskommentiert werden

		// Tabelle leeren
		for (int x = 0; x < anzahlZeilen; x++) {
			for (int y = 0; y < anzahlSpalten; y++) {
				System.out.println("Zeile: " + (x + 1) + " Spalte: " + (y + 1) + " " + tabelle[x][y]);
			}
		}
	}
}
