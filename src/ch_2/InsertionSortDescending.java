package ch_2;

public class InsertionSortDescending {
	public static int[] insertionSortDesc(int[] input) {
		for (int j = 1; j< input.length; j++) {
			int i = j-1, key = input[j];
			while(i > 0  && input[i] < key) {
				input[i+1] = input[i];
				i--;
			}
			input[i+1] = key;
		}
		return input;
	}
}
