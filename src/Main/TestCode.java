package Main;


import ch_2.Insertion;
import ch_2.InsertionSortDescending;
import ch_2.MergeSort;
import ch_2.ex_2_1_3_LinearSearch;
import ch_2.ex_2_1_4_BinaryAddition;
import ch_4.MaxSubArrayDivideAndConquer;
import ch_4.MaxSubarrayLinearTime;
import ch_6.HeapSort;

public class TestCode {
	public static void main(String[] args) {
		int[] input = {13, 3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		print(HeapSort.heapSort(input));
//		System.out.println("The inversion count " + MergeSort.inversionCount);
	}
	private static void print(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
