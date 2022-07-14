package ch_2;

public class Insertion {
	public static int[] insertionSort(int[] input) {
		for (int i = 0; i < input.length - 1; i++) { // we are starting empty hand and going until we see all the cards
			int key = input[i+1], j = i;
			while (j > 0 && input[j] > key) { // we match each card and move leftward until we find the correct position
				input[j+1] = input[j];
				j--;
			}
			input[j+1] = key; // Once we find the correct position in between or we reach to the left end we insert the card
		}
		return input;
	}
}
