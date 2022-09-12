package Main;

import ch_15.practice_problems.LeetcodeProblem5;

public class TestCode {
	public static void main(String[] args) {
		System.out.println(LeetcodeProblem5.longestPalindromeBottomUp("babbad"));
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
