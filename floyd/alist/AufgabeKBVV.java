package alist;

import java.util.ArrayList;

public class AufgabeKBVV {
	public static void main(String... args) {
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		lotto.add(1);
		lotto.add(17);
		lotto.add(25);
		lotto.add(30);
		lotto.add(31);
		lotto.add(33);
		if (lotto.contains(12)) {
			System.out.println("12 ist in der Liste!");
		}
		if (lotto.contains(31)) {
			System.out.println("31 ist in der Liste!");
		}
		System.out.println("Länge: " + lotto.size());
		lotto.remove(1);
		for (Integer i : lotto) {
			System.out.println(i);
		}
	}
}
