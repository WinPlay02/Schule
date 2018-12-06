public class fibonacci {

	public static void main(String... args) {
		maxfibonacci(5000);
	}

	public static void maxfibonacci(int len) {
		long[] table = new long[len];
		for (int i = 0; i < len; i++) {
			table[i] = -1;
		}
		for (int i = 0; i < len; i++) {
			System.out.println("Idx: " + i + " | " + methodfibonacci(i, table));
		}
	}

	public static long methodfibonacci(int n, long[] table) {
		if (n < 0)
			return 0;
		if (table[n] != -1)
			return table[n];
		if (n == 0)
			return 1;
		long num = methodfibonacci(n - 1, table) + methodfibonacci(n - 2, table);
		table[n] = num;
		return num;
	}
}
