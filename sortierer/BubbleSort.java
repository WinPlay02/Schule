package datenfelder;

public class BubbleSort {
	public static void main(String... args) {
		int[] feld = { 2, 1, 5, 4, 2, 5, 5, 9, 6, 3, 5, 4, 8, 5, 1, 1, 1, 2, 6, 5, 4, 8, 6, 4, 1, 2, 5, 74, 8, 9, 5, 6,
				48, 968, 486, 486, 468, 4, 68, 4, 86, -5, -85, -747, -85, -5 };
		for (int x = 0; x < feld.length - 1; x++) {
			for (int i = 0; i < feld.length - 1; i++) {
				if (feld[i] > feld[i + 1]) {
					int swap = feld[i];
					feld[i] = feld[i + 1];
					feld[i + 1] = swap;
				}
			}
		}
		for (int i = 0; i < feld.length; i++) {
			System.out.println(feld[i]);
		}
	}
}
