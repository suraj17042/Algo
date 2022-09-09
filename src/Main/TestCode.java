package Main;

import ch_15.MatrixChainMultiplication;
import ch_15.RodCuttingProblem;
import ch_15.ex_15_1.ex_15_1_3;
import ch_15.ex_15_1.ex_15_1_4;

import java.time.Duration;
import java.time.Instant;

public class TestCode {
	public static void main(String[] args) {
	int[] dimenson = {10, 40, 20};
	MatrixChainMultiplication.matrixChainRecursive(dimenson);
	System.out.println();
	MatrixChainMultiplication.matrixChainBottomUp(dimenson);
//		Instant start = Instant.now();
//		print("" + RodCuttingProblem.rodCuttingNaiveRecursion(price, 10));
//	Instant stop = Instant.now();
//	System.out.println("the duration is " + Duration.between(start, stop));
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
