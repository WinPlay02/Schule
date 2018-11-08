package muenzen;

import java.util.Random;

import datentype.Stack;

/**
 * @author Sara, Winston
 */
public class Muenzenstapel {

	// Random
	static Random RANDOM = new Random();

	// Zufallszahl errechnen mit Switch
	public static int getNextRandom() {
		int ran = RANDOM.nextInt(5);
		switch (ran) {
		case 0:
			return 10;
		case 1:
			return 20;
		case 2:
			return 50;
		case 3:
			return 100;
		case 4:
			return 200;
		default://
			break;
		}
		return 0;
	}

	// Einstiegspunkt
	public static void main(String... args) {
		Muenzenstapel ms = new Muenzenstapel();

		for (int i = 0; i < 20; i++) {
			ms.muenzenStapeln();
		}
		ms.sortieren();
		ms.ausgabe();
	}

	private int zaehler;
	private int[][] geldzaehler;

	// ein Stack: gemischter Stapel:
	Stack<Muenze> muenzen;
	// 5 Stacks: für jede Münzsorte einer:
	Stack<Muenze> cent10, cent20, cent50, euro1, euro2;

	// Konstruktor: 5 verschiedene Münz-Stapel:
	Muenzenstapel() {
		cent10 = new Stack<Muenze>();
		cent20 = new Stack<Muenze>();
		cent50 = new Stack<Muenze>();
		euro1 = new Stack<Muenze>();
		euro2 = new Stack<Muenze>();
		muenzen = new Stack<Muenze>();
		zaehler = 0;
		geldzaehler = new int[2][6]; // 1. [0] Koordinate Wert pro Stack
		// 1. [1] Koordinate: Anzahl der Münzen pro Stack
		// 2. Koordinate: Der Münzstapel, der 5. ist eine Gesamtzählung
	}

	// Aufgabe Teil a): Stapeln der Münzen
	public void muenzenStapeln() {
		while (zaehler < 20) {
			muenzen.push(new Muenze(getNextRandom()));
			zaehler++;
		}
	}

	// Aufgabe Teil b): Sortieren der Münzen
	public void sortieren() {
		Muenze m;
		while ((m = muenzen.top()) != null) {
			int aktuellerWert = m.getWert();
			muenzen.pop();
			geldzaehler[0][5]++;
			geldzaehler[1][5] += aktuellerWert;
			switch (aktuellerWert) {
			case 10:
				geldzaehler[0][0]++;
				geldzaehler[1][0] += aktuellerWert;
				cent10.push(m);
				break;
			case 20:
				geldzaehler[0][1]++;
				geldzaehler[1][1] += aktuellerWert;
				cent20.push(m);
				break;
			case 50:
				geldzaehler[0][2]++;
				geldzaehler[1][2] += aktuellerWert;
				cent50.push(m);
				break;
			case 100:
				geldzaehler[0][3]++;
				geldzaehler[1][3] += aktuellerWert;
				euro1.push(m);
				break;
			case 200:
				geldzaehler[0][4]++;
				geldzaehler[1][4] += aktuellerWert;
				euro2.push(m);
				break;
			default:
				break;
			}
		}
	}

	// Ausgabe der Werte
	public void ausgabe() {
		System.out.println("Anzahl 10 Cent Münzen: " + geldzaehler[0][0] + ", Wert: " + geldzaehler[1][0] + " Cent");
		System.out.println("Anzahl 20 Cent Münzen: " + geldzaehler[0][1] + ", Wert: " + geldzaehler[1][1] + " Cent");
		System.out.println("Anzahl 50 Cent Münzen: " + geldzaehler[0][2] + ", Wert: " + geldzaehler[1][2] + " Cent");
		System.out.println("Anzahl 1€ Münzen: " + geldzaehler[0][3] + ", Wert: " + geldzaehler[1][3] + " Cent");
		System.out.println("Anzahl 2€ Münzen: " + geldzaehler[0][4] + ", Wert: " + geldzaehler[1][4] + " Cent");
		System.out.println(
				"Gesamtes Barvermögen, Münzen: " + geldzaehler[0][5] + ", Wert: " + geldzaehler[1][5] + " Cent");
	}
}
