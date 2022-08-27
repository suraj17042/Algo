package ch_15.ex_15_1;

public class ex_15_1_3 {
    private static final int COST_OF_CUTTING = 1;

    // Top - down

    public static int rodCuttingTopDownWithCuttingCost(int price[], int size){
        int r[] = new int[size + 1];
        int choice[] = new int[size + 1];
        for(int i = 0; i <= size; i++)
            r[i] = Integer.MIN_VALUE;
        return rodCuttingHelper(price, r, choice, size);
    }

    private static int rodCuttingHelper(int[] price, int [] r, int[] choice, int size){
        if (size == 0)
            return 0;
        if (r[size] > 0)
            return r[size];
        int maxRevenue = Integer.MIN_VALUE;
        for (int i = 1; i <= size; i++){
            maxRevenue = Integer.max(maxRevenue, price[i] + rodCuttingHelper(price, r, choice, size - i) - ((i == size) ? 0 : COST_OF_CUTTING));
        }
        r[size] = maxRevenue;
        return maxRevenue;
    }

    // Bottom up

    public static int rodCuttingBottomUpWithCuttingCost(int price[], int size){
        int r[] = new int[size + 1];
        for (int i = 0; i <= size; i++)
            r[i] = Integer.MIN_VALUE;
        r[0] = 0;
        for (int i = 1; i <= size; i++){
            int maxRevenue = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++){
                maxRevenue = Integer.max(maxRevenue, price[j] + r[i-j] - ((i == j) ? 0 : COST_OF_CUTTING));
            }
            r[i] = maxRevenue;
        }
        return  r[size];
    }
}
