package ch_2;

import java.util.Arrays;

public class MergeSort {
	public static int inversionCount;
	public static int[] mergeSort(int [] input) {
		if (input.length == 1) {
			return input;
		}
//		int [] subArray1 = mergeSort(Arrays.copyOfRange(input, 0, input.length/2));
//		int [] subArray2 = mergeSort(Arrays.copyOfRange(input, input.length/2, input.length))
		return merge(mergeSort(Arrays.copyOfRange(input, 0, input.length/2)), mergeSort(Arrays.copyOfRange(input, input.length/2, input.length)));
	}
	
	public static int[] merge(int[] subarray1, int[] subarray2) {
		int i = 0, j = 0, k = 0;
		int [] arr = new int[subarray1.length + subarray2.length];
		while(i < subarray1.length && j < subarray2.length) {
			if (subarray1[i] > subarray2[j]) {
				inversionCount += subarray1.length - i;
				arr[k] = subarray2[j];
				k++;
				j++;
			}
			else {
				arr[k] = subarray1[i];
				k++;
				i++;
			}
		}
		if (i < subarray1.length) {
			while (i < subarray1.length) {
				arr[k] = subarray1[i];
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
