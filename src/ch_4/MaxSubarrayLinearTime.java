package ch_4;

import java.util.Arrays;

public class MaxSubarrayLinearTime {
	public static int[] maxSubArray(int[] input) {
		int finalSum = Integer.MIN_VALUE, i = 0, sum = 0, startIndex = 0, endIndex = 0, j = 0;
		while(i < input.length) {
			 startIndex = i;
			 j = i;
			 sum = 0;
			 while(sum >= 0 && j < input.length) {
				 sum += input[j];
				 j++;
				 if (sum > finalSum) {
					 finalSum = sum;
					endIndex = j; 
				 }
			 }
			 i = j;
			 
			 
		}
		return Arrays.copyOfRange(input, startIndex, endIndex);
	}
}
