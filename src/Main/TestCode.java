package Main;

import ch_6.PriorityQueue;

public class TestCode {
	public static void main(String[] args) {
		int[] input = {10, 9, 8, 7, 6, 5,4,3,2,1,0};
		int heapSize = input.length - 1;
		System.out.println(PriorityQueue.extractMax(input, heapSize));
		heapSize--;
		print(input);
		PriorityQueue.increaseKey(input, 8, 8, heapSize);
		System.out.println();
		print(input);
		System.out.println();
		PriorityQueue.insert(input, 7, heapSize);
		print(input);
		
//		System.out.println("The inversion count " + MergeSort.inversionCount);
	}
	private static void print(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
