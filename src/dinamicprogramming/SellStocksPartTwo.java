package dinamicprogramming;
//infinite times
public class SellStocksPartTwo  {
    public int maxProfit(int[] prices) {
        int bd = 0,sd = 0, p = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] >= prices[i-1]){
                sd++;
            }
            else{
                p += prices[sd] - prices[bd];
                bd = sd = i;
            }
        }
        p += prices[sd] - prices[bd];
        return p;

    }
}
