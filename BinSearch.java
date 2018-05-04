package datenfelder;

public class BinSearch {

	/**
	 * binäre Suche
	 * 
	 * @param array Feld, in dem gesucht wird
	 * @param search Gesuchter Wert
	 * @return Index des gesuchten Wertes
	 */
	public static int binSearch(int[] array, int search) {
		// Ungültige Werte werden ausgeschloßen.
		if (search > array[array.length - 1] || search < array[0])
			return -1;
		// Minimum, Maximum und die Mitte werden initialisiert.
		int min = 0;
		int mid = array.length / 2;
		int max = array.length;
		// Der Mittlere Wert verschiebt den Bereich bis er auf den gesuchten Wert gekommen ist. 
		while (array[mid] > search) {
			max = mid;
			min = 0;
			mid = (max + min) / 2;
		}
		// Der Mittlere Wert verschiebt den Bereich bis er auf den gesuchten Wert gekommen ist. 
		while (array[mid] < search) {
			min = mid;
			max = array.length;
			mid = (max + min) / 2;
		}
		return mid;
	}

	public static void main(String... args) {
		int search = 20;
		//
		int[] array = { 2, 5, 7, 8, 12, 14, 18, 20 };
		//
		int index = binSearch(array, search);
		//
		System.out.println("Index: " + index + " Wert: " + array[index]);
	}
}
