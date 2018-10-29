package palindrom;

import java.util.Scanner;

/**
 * @author Sara, Malte, Winston
 */
public class Vergleich {

	public static String input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Eingabe> ");
		String s = sc.nextLine();
		sc.close();
		return s.toLowerCase();
	}

	/**
	 * Absichtlich
	 * 
	 * @return Palindrom? true / false
	 */
	public static boolean palindrom(String text) {
		char[] array = text.toCharArray();
		for (int i = 0; i < array.length / 2; i++) {
			if (array[i] != array[array.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String... args) {
		System.out.println(palindrom(input()) ? "Palindrom! Wow" : "Kein Palindrom! Haha");
	}

}
