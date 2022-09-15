package Main;

import ch_15.leetcode_problems.Problem10;
import ch_15.leetcode_problems.Problem5;

public class TestCode {
	public static void main(String[] args) {
		System.out.println(Problem10.regexPatternMatchingBottomUp("a", "ab*"));
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
