package ch_2;

public class ex_2_1_3_LinearSearch {
	public static Integer linearSearch(int[] input, int v) {
		for(int i = 0; i < input.length; i++) {
			if(input[i] == v)
				return i;
		}
		return null;
	}
}
