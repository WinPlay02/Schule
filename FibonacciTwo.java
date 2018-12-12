package bakterien;

import java.math.BigInteger;

public class FibonacciTwo {

	public static void main(String... args) {
		maxfibonacci(18890);
	}

	public static void maxfibonacci(int len) {
		BigInteger[] table = new BigInteger[len];
		for (int i = 0; i < len; i++) {
			table[i] = new BigInteger("-1");
		}
		for (int i = 0; i < len; i++) {
			System.out.println("Idx: " + i + " | " + methodfibonacci(i, table));
		}
	}

	public static BigInteger methodfibonacci(int n, BigInteger[] table) {
		if (n < 0)
			return new BigInteger("0");
		if (table[n].intValue() != -1)
			return table[n];
		if (n == 0)
			return new BigInteger("1");
		BigInteger num = methodfibonacci(n - 1, table).add(methodfibonacci(n - 2, table));
		table[n] = num;
		return num;
	}
}
