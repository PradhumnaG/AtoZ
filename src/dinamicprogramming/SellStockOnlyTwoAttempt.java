package dinamicprogramming;

public class SellStockOnlyTwoAttempt {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int profit1 = 0;
        int buy2 = Integer.MAX_VALUE;
        int profit2 = 0;

        for (int price : prices) {

            buy1 = Math.min(buy1, price);

            profit1 = Math.max(profit1, price - buy1);


            buy2 = Math.min(buy2, price - profit1);

            profit2 = Math.max(profit2, price - buy2);
        }

        return profit2;

    }
}
/*
Price,Logic Check,buy1 (Min Price),profit1 (Max P1),buy2 (Min Eff. Cost),profit2 (Max Total)
Start,Init,MAX,0,MAX,0
        3,Initial buy,3,0,3,0
        3,No change,3,0,3,0
        5,Sell 1 opportunity!,3,2 (5-3),3 (5-2),2
        0,New Low found!,0,2,-2 (0-2),2
        0,No change,0,2,-2,2
        3,Better P1?,0,3 (3-0),-2,5 (3 - (-2))
        1,Dip,0,3,-2,5
        4,Final Peak!,0,4 (4-0),-2,6 (4 - (-2))*/
