package datenfelder;
/**
 * 
 * @author winston.oberlaender
 *
 */
public class BinSearch {
	/**
	 * binäre Suche
	 * 
	 * @param array
	 *            Feld, in dem gesucht wird
	 * @param search
	 *            Gesuchter Wert
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
		if (array[mid] > search) {
			max = mid;
			min = 0;
			mid = (max + min) / 2;
		}
		if (array[mid] < search) {
package datenfelder;
/**
 * 
 * @author winston.oberlaender
 *
 */
public class BinSearch {
	/**
	 * binäre Suche
	 * 
	 * @param array
	 *            Feld, in dem gesucht wird
	 * @param search
	 *            Gesuchter Wert
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
		if (array[mid] > search) {
			max = mid;
			min = 0;
			mid = (max + min) / 2;
		}
		if (array[mid] < search) {
			min = mid;
			max = array.length;
			mid = Math.round((max + min) / 2.0f);
		}
		while (array[mid] != search) {
			if (array[mid] < search) {
				max = mid + (mid - min) + 1;
				min = mid;
				mid = Math.round((max + min) / 2.0f);
			}
			// Der Mittlere Wert verschiebt den Bereich bis er auf den gesuchten Wert
			// gekommen ist.
			if (array[mid] > search) {
				min = mid - (max - mid) - 1;
				max = mid;
				mid = Math.round((max + min) / 2.0f);
			}
		}
		return mid;
	}
	/**
	 * @param args
	 */
	public static void main(String... args) {
		//
		int[] array = { 2, 5, 7, 8, 9, 12, 30, 40, 50, 7489, 48798 };
		//
		for (int i = 0; i < array.length; i++) {
			int index = binSearch(array, array[i]);
			if (i != index)
				System.out.println(
						"FIndex: " + i + " SIndex: " + array[i] + " Index: " + index + " Wert: " + array[index]);
		}
	}
}			min = mid;
			max = array.length;
			mid = Math.round((max + min) / 2.0f);
		}
		while (array[mid] != search) {
			if (array[mid] < search) {
				max = mid + (mid - min) + 1;
				min = mid;
				mid = Math.round((max + min) / 2.0f);
			}
			// Der Mittlere Wert verschiebt den Bereich bis er auf den gesuchten Wert
			// gekommen ist.
			if (array[mid] > search) {
				min = mid - (max - mid) - 1;
				max = mid;
				mid = Math.round((max + min) / 2.0f);
			}
		}
		return mid;
	}
	/**
	 * @param args
	 */
	public static void main(String... args) {
		//
		int[] array = { 2, 5, 7, 8, 9, 12, 30, 40, 50, 7489, 48798 };
		//
		for (int i = 0; i < array.length; i++) {
			int index = binSearch(array, array[i]);
			if (i != index)
				System.out.println(
						"FIndex: " + i + " SIndex: " + array[i] + " Index: " + index + " Wert: " + array[index]);
		}
	}
}
