package datenfelder;

public class ArraySort {

	/**
	 * Haupteinstiegspunkt
	 * @param args Parameter
	 */
	public static void main(String[] args) {
		// Die vorgegebenen Werte
		int[] _datenfeld = { 210, 190, 220, 215, 230, 225 };
		// Resultate
		int[] _result = new int[_datenfeld.length];
		// 0 Wert
		int smallest = 0;
		// Index (ungültig)
		int index = -1;
		// Iteration durch Datenfeld
		for (int i = 0; i < _datenfeld.length; i++) {
			// Kleinsten wert auf derzeitigen setzen
			smallest = _datenfeld[i];
			// Nach kleinstem Wert weitere Iteration durchführen
			for (int x = 0; x < _datenfeld.length; x++) {
				// Kleinsten Wert suchen
				if (smallest > _datenfeld[x]) {
					// Kleinsten Wert setzen
					smallest = _datenfeld[x];
					// Index Setzen
					index = x;
				}
			}
			// Wert kopieren
			_result[i] = _datenfeld[index];
			// Wert löschen, mit Wert grösser als der Grösste
			_datenfeld[index] = 250;
		}
		// Ausgabe
		for (int i = 0; i < _datenfeld.length; i++) {
			System.out.println("I: " + _result[i]);
		}
	}
}
