package dinamicprogramming;

import java.util.List;

public class TriangleSumLonetwenty {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int currentVal = triangle.get(i).get(j);
                dp[j] = currentVal + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];


    }
}
