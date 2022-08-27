package Main;

import ch_15.RodCuttingProblem;

import java.time.Duration;
import java.time.Instant;

public class TestCode {
	public static void main(String[] args) {

	int[] price = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		Instant start = Instant.now();
	print("" + RodCuttingProblem.reconstuctingRodCuttingSolution(price, 4));
//		print("" + RodCuttingProblem.rodCuttingNaiveRecursion(price, 10));
	Instant stop = Instant.now();
	System.out.println("the duration is " + Duration.between(start, stop));
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
