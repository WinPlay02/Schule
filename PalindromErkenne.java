package palindrom;

import java.util.Scanner;
import datentype.Stack;

public class PalindromErkenne {

	public static String input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Eingabe> ");
		String s = sc.nextLine();
		sc.close();
		return s.toLowerCase();
	}

	public static void main(String... agrs) {
		Stack<Character> stack = new Stack<Character>();
		boolean ungleich = false;
		String eingabe = input();

		char[] a = eingabe.toCharArray();
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
		if (ungleich) {
			System.out.println("kein Palindrom!");
		} else {
			System.out.println("ein Palindrom! Wow!");
		}
	}
}
