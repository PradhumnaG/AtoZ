package dinamicprogramming;

public class BestTimeToBusyStocksWithFee  {
    public int maxProfit(int[] prices, int fee) {

        if (prices == null || prices.length == 0) {
            return 0;
        }


        int bsp = -prices[0];

        int ssp = 0;

        for (int i = 1; i < prices.length; i++) {

            int new_bsp = Math.max(bsp, ssp - prices[i]);


            int new_ssp = Math.max(ssp, bsp + prices[i] - fee);


            bsp = new_bsp;
            ssp = new_ssp;
        }


        return ssp;
    }
}
