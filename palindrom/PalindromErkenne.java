package palindrom;

import java.util.Scanner;
import datentype.Stack;

/**
 * @author Sara, Malte, Winston
 */
public class PalindromErkenne {

	public static String input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Eingabe> ");
		String s = sc.nextLine();
		sc.close();
		return s.toLowerCase();
	}

	public static boolean palindromPruefen(String pEingabe) {
		Stack<Character> stack = new Stack<Character>();
		boolean ungleich = false;

		char[] a = pEingabe.toCharArray();
		boolean[] palindrome = new boolean[a.length];

		for (int zaehler = 0; zaehler < a.length; zaehler++) {
			stack.push(a[zaehler]);
		}

		for (int zaehler = 0; zaehler < a.length; zaehler++) {
			palindrome[zaehler] = stack.top() == (char) a[zaehler];
			if (!palindrome[zaehler]) {
				ungleich = true;
			}
			stack.pop();
		}
		return ungleich;
	}

	public static void main(String... agrs) {
		boolean ungleich = palindromPruefen(input());

		if (ungleich) {
			System.out.println("Kein Palindrom!");
		} else {
			System.out.println("Ein Palindrom! Wow!");
		}
	}
}
