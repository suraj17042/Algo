package ch_2;

public class Insertion {
	public static int[] insertionSort(int[] input) {
		for (int i = 0; i < input.length - 1; i++) {
			int key = input[i+1], j = i;
			while (j > 0 && input[j] > key) {
				input[j+1] = input[j];
				j--;
			}
			input[j+1] = key;
		}
		return input;
	}
}
