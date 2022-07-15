package ch_6;



/**
 *  Priority Queues have the following operations (Here is max-priority-queue presented)
 *  Max-Queue-Insert - Insert new element in and existing  priority queue
 *  Max - return  the maximum element
 *  Extract Max - Remove and return the maximum element from a priority queue
 *  Increase-key - Increase the value of an element to a value k
 *  
 *  Note:- For the priority queue heap is the most efficient data structure so
 *  we will assume that input passed to each of the method is max-heap(since we are studying
 *  max-priority-queue
 *
 */
public class PriorityQueue {
	
	public static int max(int[] input, int heapSize) {
		return input[0];
	}
	
	public static int extractMax(int[] input, int heapSize) {
		int max = input[0];
		swap(input, 0, heapSize);
		HeapSort.maxHeapify(input, 0, heapSize--);
		return max;
		
	}
	
	public static void increaseKey(int [] input, int index, int key, int heapSize) {
		if(key < input[index]) {
			System.out.println("The new key is less than old key");
			return;
		}
		input[index] = key;
		while (index >= 0 && key > input[index/2]) {
			swap(input, index, index/2);
			index /= 2;
		}
	}
	
	public static void insert(int[] input, int key, int heapSize) {
		heapSize++;
		input[heapSize] = Integer.MIN_VALUE;
		increaseKey(input, heapSize, key, heapSize);
	}
	
	public static void swap(int[] input, int index1, int index2) {
		int temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}
}
