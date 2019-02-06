package quicksort;

import java.util.Arrays;

public class Quicksort {

	// Einstiegspunkt
	public static void main(String... args) {
		int[] array = { 5, 6, 1, 3, 2, 6, 3, 5, 9, 8, 85, 6, 3, 2, 1 };
		System.out.println("Unsortiert: " + arrays_deepToString(array));
		q_sortieren(array, 0, array.length - 1);
		System.out.println("Sortiert: " + arrays_deepToString(array));
	}

	// Für die Ausgabe des Arrays
	public static String arrays_deepToString(int[] array) {
		return Arrays.deepToString(Arrays.stream(array).boxed().toArray());
	}

	// Schleifenweise Ausgabe des Arrays
	public static String deepToString(int[] a) {
		String s = "[ ";
		for (int i : a) {
			s = s + i + " ";
		}
		s = s + "]";
		return s;
	}

	// Quicksort
	public static void q_sortieren(int[] array, int start, int ende) {
		int ersterIndex = start;
		int letzterIndex = ende;
		int pivotIndex = start + (ende - start) / 2;
		int pivotElement = array[pivotIndex];
		while (start < ende) {
			while (!(pivotElement <= array[start])) {
				start++;
			}
			while (!(pivotElement >= array[ende])) {
				ende--;
			}
			if (start < ende) {
				int temp = array[start];
				array[start] = array[ende];
				array[ende] = temp;
				start++;
				ende--;
			}
			if (start < letzterIndex) {
				q_sortieren(array, ersterIndex, ende);
			}
			if (ende > ersterIndex) {
				q_sortieren(array, start, letzterIndex);
			}
		}
	}

}
