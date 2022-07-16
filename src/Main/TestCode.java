package Main;

import ch_6.PriorityQueue;
import ch_7.Quicksort;

public class TestCode {
	public static void main(String[] args) {
		int[] input = {10, 9, 8, 7, 6, 5,4,3,2,1,0,1,2,3,4,5,6,7,10};
		print(Quicksort.quickSort(input, 0, input.length - 1));
	}
	private static void print(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
