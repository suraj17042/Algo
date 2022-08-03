package ch_10;

public class Stack {
	private int MAX;
	private int top = -1;
	private int [] arr;
	public Stack(int max) {
		super();
		MAX = max;
		arr = new int[MAX];
	}
	
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}
	
	public Integer push(int value) {
		if (top == MAX - 1) {
			System.out.println("Stack Overflow. Element " + value + " couldn't be added");
			return null;
		}
		top++;
		arr[top] = value;
		return value;
	}
	
	public Integer pop() {
		if (isEmpty()) {
			System.out.println("Stack underflow");
			return null;
		}
		int value = arr[top];
		top--;
		return value;
	}
	
	public void printStack() {
		for (int i = 0; i <= top; i++)
			System.out.print(arr[i]+ " ");
		System.out.println();
	}
}
