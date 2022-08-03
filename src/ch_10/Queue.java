package ch_10;

public class Queue {
	private int capacity;
	private int head = -1, tail = -1;
	private int[] arr;
	public Queue(int capacity) {
		super();
		this.capacity = capacity;
		arr = new int[capacity];
	}
	
	public boolean isFull() {
		if (head + 1 == capacity)
			return true;
		return false;
	}
	
	public boolean isEmpty() {
		if (head == tail)
			return true;
		return false;
	}
	
	public Integer enqueue(int value) {
		if (isFull()) {
			System.out.println("Queue is full. Couldn't add the element " + value);
			return null;
		}
		head++;
		arr[head] = value;
		return value;
	}
	
	public Integer dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty. Nothing to dequeue");
			return null;
		}
		tail++;
		int value = arr[tail];
		return value;
	}
	
	public void printQueue() {
		for (int i = tail+1; i <= head; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
