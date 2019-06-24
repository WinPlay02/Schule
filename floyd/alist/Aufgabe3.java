package alist;

import java.util.ArrayList;

public class Aufgabe3 {
	public static void main(String... args) {
		ArrayList<String> lieblingsFaecher = new ArrayList<String>();
		lieblingsFaecher.add("Fach1");
		lieblingsFaecher.add("Fach2");
		lieblingsFaecher.add("Fach3");
		for (String fc : lieblingsFaecher) {
			System.out.println(fc);
		}
		lieblingsFaecher.set(2, "Brokkoli");
		for (String fc : lieblingsFaecher) {
			System.out.println(fc);
		}
	}
}
