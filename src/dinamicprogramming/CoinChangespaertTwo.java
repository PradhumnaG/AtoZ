package dinamicprogramming;

public class CoinChangespaertTwo  {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] cache = new int[n][amount + 1];


        for (int i = 0; i < n; i++) {
            cache[i][0] = 1;
        }//


        for (int j = 1; j <= amount; j++) {
            int remaining = j - coins[0];
            if (remaining >= 0) {
                cache[0][j] = cache[0][remaining];
            }
        }//


        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {

                int skip = cache[i - 1][j];


                int take = 0;
                if (j - coins[i] >= 0) {
                    take = cache[i][j - coins[i]];
                }


                cache[i][j] = skip + take;
            }
        }


        return cache[n - 1][amount];

    }
}
