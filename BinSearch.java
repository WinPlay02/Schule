package datenfelder;

public class BinSearch {

	public static int binSearch(int[] array, int search) {
		if (search > array[array.length - 1] || search < array[0])
			return -1;
		int min = 0;
		int mid = array.length / 2;
		int max = array.length;
		int temp = array[mid];
		while (temp > search) {
			max = mid;
			min = 0;
			mid = (max + min) / 2;
			temp = array[mid];
			// System.out.println("> Max: " + max + " Mid: " + mid + " Min: " + min + "
			// Temp: " + temp);
		}
		while (temp < search) {
			min = mid;
			max = array.length;
			mid = (max + min) / 2;
			temp = array[mid];
			// System.out.println("< Max: " + max + " Mid: " + mid + " Min: " + min + "
			// Temp: " + temp);
		}
		return mid;
	}

	public static void main(String... args) {
		int search = 20;
		//
		int[] array = { 2, 5, 7, 8, 12, 14, 18, 20 };
		//
		int index = binSearch(array, search);
		//
		System.out.println("Index: " + index + " Wert: " + array[index]);
	}
}
