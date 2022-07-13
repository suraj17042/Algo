package ch_4;

import java.util.Arrays;
// This will take O(nlog(n))
public class MaxSubArrayDivideAndConquer {
	public static int[] maxSubarray(int [] input) {
		if (input.length == 1)
			return input;
		return max(maxSubarray(Arrays.copyOfRange(input, 0, input.length/2)) ,
		maxSubarray(Arrays.copyOfRange(input, input.length/2, input.length)),
		maxWithMid(input));
	}
	private static int[] max(int[] arr1, int[] arr2, int[] arr3) {
		int sum1 = Arrays.stream(arr1).sum();
		int sum2 = Arrays.stream(arr2).sum();
		int sum3 = Arrays.stream(arr3).sum();
		if (sum1 > sum2 && sum1 > sum3) {
			return arr1;
		}
		else if(sum2 > sum1 && sum2 > sum3) {
			return arr2;
		}
		else
			return arr3;
	}
	private static int[] maxWithMid(int[] inp) {
		int mid = inp.length/2, i = mid, j=mid, left_sum = inp[mid], sum = inp[mid];
		for (int k = mid-1; k >= 0; k--) {
			sum += inp[k];
			if (sum > left_sum) {
				i = k;
				left_sum = sum;
			}
			
		}
		int right_sum = inp[mid];
		sum = inp[mid];
		for (int k = mid + 1; k < inp.length; k++) {
			sum += inp[k];
			if (sum > right_sum) {
				j = k;
				right_sum = sum;
			}
			
		}
		return Arrays.copyOfRange(inp, i, j+1);
		
	}

}
