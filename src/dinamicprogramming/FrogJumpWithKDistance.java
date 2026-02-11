package dinamicprogramming;
import java.util.Arrays;
class FrogJumpWithKDistance

 {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        if (n == 0) return 0;

        // dp[i] will store the minimum cost to reach stone i
        int[] dp = new int[n];

        // Initialize dp array with a large number (infinity)
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case: Cost to reach the first stone (index 0) is 0
        dp[0] = 0;

        // Iterate through every stone from 1 to n-1
        for (int i = 1; i < n; i++) {
            // Check all possible jumps from previous stones (1 to k steps back).
            for (int j = 1; j <= k; j++) {
                // Ensure we don't look back past the start of the array
                if (i - j >= 0) {
                    // Calculate cost coming from stone (i-j)
                    int jumpCost = dp[i - j] + Math.abs(heights[i] - heights[i - j]);

                    // Update the minimum cost for the current stone 'i'
                    dp[i] = Math.min(dp[i], jumpCost);
                }
            }
        }

        // The answer is the cost to reach the last stone
        return dp[n - 1];
    }
}
