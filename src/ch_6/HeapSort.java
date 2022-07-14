package ch_6;

public class HeapSort {

	
	public static int [] heapSort(int[] input) {
		buildMaxHeap(input);
		int heapSize = input.length - 1;
		while (heapSize > 0) {
			swap(input, 0, heapSize);
			heapSize--;
			maxHeapify(input, 0, heapSize);
		}
		return input;
	}
	
	public static void buildMaxHeap(int[] input) {
		for(int i = input.length/2; i >= 0 ; i--) {
			maxHeapify(input, i, input.length-1);
		}
	}
	
	
	public static void maxHeapify(int[] input, int index, int heapSize) {
		while(index*2 <= heapSize) {
			int largestIndex = index;
			if(input[index] < input[index*2]) {
				largestIndex = index*2;
			}
			if (index*2 + 1 <= heapSize && input[largestIndex] < input[index*2 + 1]) {
				largestIndex = index * 2 + 1;
			}
			if(largestIndex == index) {
				break;
			}
			swap(input, index, largestIndex);
			maxHeapify(input, largestIndex, heapSize);
		}
	}
	
	public static void swap(int[] input, int index1, int index2) {
		int temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}
}
