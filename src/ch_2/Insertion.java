package ch_2;

public class Insertion {
	public static int[] insertionSort(int[] input) {
		for (int i = 0; i < input.length - 1; i++) { // we are starting empty hand and going until we see all the cards
			int key = input[i+1], j = i;	// i denotes the number of card in the hand where we put the card in sorted order. If we consider only the farst card then its trivially sorted. so starting the iteration with the second card
			while (j > 0 && input[j] > key) { // we match each card and move leftward until we find the correct position
				input[j+1] = input[j];
				j--;
			}
			input[j+1] = key; // Once we find the correct position in between or we reach to the left end we insert the card
		}
		return input;
	}
}
