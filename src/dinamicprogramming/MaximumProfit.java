package dinamicprogramming;

public class MaximumProfit {
    public int maxProfit(int[] prices) {
        int minP = Integer.MAX_VALUE;
        int maxProfit = 0;
        for( int price : prices){
            if(price < minP) { minP = price;}
            else if(price - minP > maxProfit){
                maxProfit = price - minP;
            }
        }
        return maxProfit;

    }
}
