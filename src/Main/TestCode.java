package Main;

import ch_15.LCS;
import ch_15.MatrixChainMultiplication;
import ch_15.RodCuttingProblem;
import ch_15.ex_15_1.ex_15_1_3;
import ch_15.ex_15_1.ex_15_1_4;

import java.time.Duration;
import java.time.Instant;

public class TestCode {
	public static void main(String[] args) {
	String s1 = "ABCBD";
	String s2 = "BAA";
	System.out.println(LCS.lCSBottomUp(s1, s2));
	System.out.println(LCS.longestCommonSubsequence(s1, s2));
	}
	private static void print(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " " );
		}
	}

	private static void print(String s){
		System.out.println(s);
	}
}
