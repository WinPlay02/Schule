package rekursionen;

import java.util.Random;

/**
 * @author Sara Ciolino, Winston Oberlaender
 */
public class Wuerfel {

	public static Random RANDOM = new Random();

	public static void main(String... args) {
		System.out.println("Rekursiv: " + maxFindenReku(5));
		System.out.println("Iterativ: " + maxFindenReku(5));
	}

	/**
	 * Generiert eine Zahl zwischen 1 und 6, wie ein Würfel
	 * 
	 * @return 1 - 6
	 */
	public static int wuerfeln() {
		return RANDOM.nextInt(6) + 1;
	}

	/**
	 * Würfelt und ermittelt das höchste Ergebnis rekursiv
	 * 
	 * @param anzahl
	 * @return Den höchsten Wert
	 */
	public static int maxFindenReku(int anzahl) {
		if (anzahl <= 0) {
			return 0;
		} else {
			int zuvor = maxFindenReku(anzahl - 1);
			int aktuell = wuerfeln();
			if (aktuell < zuvor)
				return zuvor;
			else
				return aktuell;
		}
	}

	/**
	 * Würfelt und ermittelt das höchste Ergebnis iterativ
	 * 
	 * @param anzahl
	 * @return Den höchsten Wert
	 */
	public static int maxFindenIte(int anzahl) {
		int maxWert = 0;
		for (int i = 0; i < anzahl; i++) {
			int aktuellerWert = wuerfeln();
			if (aktuellerWert > maxWert) {
				maxWert = aktuellerWert;
			}
		}
		return maxWert;
	}

}