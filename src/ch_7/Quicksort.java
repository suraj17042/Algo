package ch_7;

// Worst case run time O(n^2) but in practice and average case it runs in O(nlogn) and even beats heapsort in practical scenerios
public class Quicksort {
	/*
	 * Idea: Choose an index and put its element(called pivot) in its correct position irrespective of the other elements i.e
	 * all the element left to that pivot will be smaller that pivot and right element will be greater than that. Now our task
	 * reduces to sort right and left array from the pivot. So recursively call the quicksort on both left and right array
	 * excluding the pivot(as it is already in its correct position). The recursive call should end when there is only one element
	 * left in the array(which is marked by left = right)
	 */
	public static int[] quickSort(int[] input, int left, int right) {
		if(left < right) { // Condition to check if the number of elements is greater than 1
			int q = partition(input, left, right); // q is the correct position for the pivot and done by partition method
			quickSort(input, left, q-1);  // recursively calling the quicksort on left and right arrays. Note that q is not included
			quickSort(input, q+1, right); // in either of them as it is already in its correct position
		}
		return input;
	}

	public static int partition(int[] input, int left, int right) {
		int i = left - 1, j = left, pivot = input[right]; // i -> index keeping record that upto i all the element is less than pivot. Initially we
		for (; j < right; j++) {  // set it to the left of the first element to mark an empty array. j iterates from the first element to one element 
			if(input[j] < pivot) { // before the pivot. If j encounter any element which is less than the pivot then i is increased and swapped with 
				i++;  				// that element because we are maintaining that after i all elements are greater than  pivot. Hence the smaller
				swap(input, i, j);  // element encountered by j will be swapped with greater element
			}
		}
		i++; // At last the correct position of the pivot will be the index just after current i as current i is the last element which is less than
		swap(input, i, right); // pivot
		return i;
	}

	public static void swap(int[] input, int index1, int index2) {
		int temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}
}
