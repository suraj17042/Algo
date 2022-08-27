package ch_15.ex_15_1;

public class ex_15_1_4 {

    public static String rodCuttingTopDownWithExactSolution(int[] price,  int size){
        int r[] = new int[size+1];
        for (int i =0; i <= size; i++)
            r[i] = Integer.MIN_VALUE;
        int choice[] = new int[size+1];
        int maxRevenue = rodCuttingHelper(price, choice, r, size);
        String solution = getSolution(choice, size);
        return "The maximum revenue which can be generated is " + maxRevenue +
                " and the lenghts of the pieces are " + solution;
    }

    private static int rodCuttingHelper(int[] price, int[] choice, int[] r, int size){
        if (size == 0)
            return 0;
        if (r[size] > 0)
            return r[size];
        int maxRevenue = Integer.MIN_VALUE;
        for (int i = 1; i <= size; i++){
            int alternateRevenue = price[i] + rodCuttingHelper(price, choice, r, size - i);
            maxRevenue = Integer.max(maxRevenue, alternateRevenue);
            if (alternateRevenue == maxRevenue)
                choice[size] = i;
        }
        r[size] = maxRevenue;
        return maxRevenue;
    }

    private static String getSolution(int choice[], int size){
        String solution = "";
        while (size > 0){
            solution = solution + " " + choice[size];
            size -= choice[size];
        }
        return solution;
    }
}
