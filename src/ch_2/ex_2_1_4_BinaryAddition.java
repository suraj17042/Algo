package ch_2;

public class ex_2_1_4_BinaryAddition {

	public static int[] binaryAddition(int[] input1, int[] input2) {
		int answerArraySize = input1.length + 1;
		int sum[] = new int[answerArraySize], k = answerArraySize - 1;
		int carry = 0, i = input1.length - 1;
		while (i >= 0) {
			if(input1[i] + input2[i] + carry == 0) {
				sum[k] = 0; carry = 0;
				i--;
				k--;
			}
			else if(input1[i] + input2[i] + carry == 1) {
				sum[k] = 1; carry = 0;
				i--; k--;
			}
			else if(input1[i] + input2[i] + carry == 2) {
				sum[k] = 0; carry = 1;
				i--; k--;
			}
			else {
				sum[k] = 1; carry = 1;
				i--; k--;
			}
		}
		if(carry == 1) {
			sum[k] = 1;
		}
		return sum;
	}
}
