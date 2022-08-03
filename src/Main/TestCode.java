package Main;

import ch_10.Queue;
import ch_10.Stack;
import ch_6.PriorityQueue;
import ch_7.Quicksort;

public class TestCode {
	public static void main(String[] args) {
//		int[] input = {10, 9, 8, 7, 6, 5,4,3,2,1,0,1,2,3,4,5,6,7,10};
//		print(Quicksort.quickSort(input, 0, input.length - 1));
		Queue queue = new Queue(3);
		queue.dequeue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.printQueue();
		queue.enqueue(3);
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		queue.enqueue(5);
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(67);
		System.out.println(queue.isEmpty() + " " + queue.isFull());
		
		
	}
	private static void print(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
