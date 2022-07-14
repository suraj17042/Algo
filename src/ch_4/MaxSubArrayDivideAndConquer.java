package ch_4;

import java.util.Arrays;
// This will take O(nlog(n))
public class MaxSubArrayDivideAndConquer {
	public static int[] maxSubarray(int [] input) {
		if (input.length == 1) // if the length of the input is 1 it is the only subarray and hence it has trivially the max sum(or min sum) because it is the only sum
			return input;
		// if length of input > 1 then there can be 3 possible scenerios for the max subarray
		return max(maxSubarray(Arrays.copyOfRange(input, 0, input.length/2)) , // 1. The max subarray resides completely in the left half of the array
		maxSubarray(Arrays.copyOfRange(input, input.length/2, input.length)),  // 2. The max subarray resides completely in the right half of the array
		maxWithMid(input));													   // 3. The max subarray crosses from left subarray to the right
		// we will compare all the three cases and whichever is max we will return
		// Q: How the above is returning the max subarray
		/* A: In case 1 if it exist completely in left subarray then we have to find the subarray of the left subarray which will have 
		 * the maximum sum and hence our problem reduces to find the maximum subarray of the left subarray which we will solve by calling the same maxSubarray method but
		 * input will be the left subarray instead of the entire subarray. Similarly, we can argue for the case 2. In case 3 there is an added condition
		 * that it must contain the mid element. So we have written a separate method for that. 
		 * 
		 */
	}
	private static int[] max(int[] arr1, int[] arr2, int[] arr3) { // This method takes 3 arrays and return the array which has the maximum sum
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
		/*
		 * We will begin from mid and move to the left keeping the record of upto where
		 * the maximum is existing till we have visited currently. We we reach to the left end 
		 * then we again start from mid but this time move to the right untill we reach to the right end
		 * keeping track of upto where it is the max. Finally, we will return the subarray between the indices
		 * which we have tracked in left and right
		 */
		int mid = inp.length/2, i = mid, j=mid, left_sum = inp[mid], sum = inp[mid]; // i = track left max index, j = track right max index
		for (int k = mid-1; k >= 0; k--) {
			sum += inp[k];
			if (sum > left_sum) { // left_sum keep track of max sum  seen so far while traversing to the left and
				i = k;			// sum keep sum of all the elements from mid to the left upto where we have visited
				left_sum = sum; // if sum > left_sum we are updating left_sum and i to keep track of the max sum seen so far and the index where it was seen
			}
			
		}
		int right_sum = inp[mid];
		sum = inp[mid]; // similar to the left operation we can do the right operation
		for (int k = mid + 1; k < inp.length; k++) {
			sum += inp[k];
			if (sum > right_sum) {
				j = k;
				right_sum = sum;
			}
			
		}
		return Arrays.copyOfRange(inp, i, j+1); // return the subarray which we have found
		
	}

}
