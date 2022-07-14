package ch_2;

import java.util.Arrays;

public class MergeSort {
	public static int[] mergeSort(int [] input) {  // if our array size is 1 its trivially sorted
		if (input.length == 1) {
			return input;
		}
		// if size of our array is greater then 1, we will divide the array into 2 half and call mergesort on each of them
		int [] subArray1 = mergeSort(Arrays.copyOfRange(input, 0, input.length/2)); // By definition of mergesort lets assume we will get the sorted subarray
		int [] subArray2 = mergeSort(Arrays.copyOfRange(input, input.length/2, input.length));
		return merge(subArray1, subArray2); // merge both the subarrays we got after calling mergesort and final answer will be the sorted array
	}
	// Q: How did the subarray in line 12 an 13 came as sorted array
	/*
	 * A: The mergesort is a recursive call to itself until it reach to the extent
	 * when the array size become 1. Once it reaches to that point, its trivially sorted and the merge method kick in.
	 * the job of the merge method is to get two sorted arrays(subarrays in our case) and return a sorted array containing the elements
	 * of both the arrays
	 */
	
	public static int[] merge(int[] subarray1, int[] subarray2) {
		int i = 0, j = 0, k = 0; // i pointing to first element of subarray1, j to subarray2 and k to finalArray 
		int [] arr = new int[subarray1.length + subarray2.length]; // creating the new array to accommodate the elements of both the arrays
		while(i < subarray1.length && j < subarray2.length) { // if there is element present in both the arrays
			if (subarray1[i] > subarray2[j]) { // second array's current element < first array's current element so
				arr[k] = subarray2[j];		   // we will insert the second array's current element into the final array and 
				k++;						   // update the pointers so that we can compare the next elements 
				j++;
			}
			else {
				arr[k] = subarray1[i];
				k++;
				i++;
			}
		}
		if (i < subarray1.length) { // this means that subarray2 is completely exhausted and subarray1 has some elements remaining so
			while (i < subarray1.length) { // we will simply push all the remaining elements of the subarray1 to the final array because 
				arr[k] = subarray1[i];	   // the arrays were already sorted and subarray2 is already exhausted
				i++; k++;
			}
		}
		if (j < subarray2.length) {
			while (j < subarray2.length) {
				arr[k] = subarray2[j];
				j++; k++;
			}
		}
		return arr; 
	}
}
