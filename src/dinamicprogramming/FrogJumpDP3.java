package dinamicprogramming;

 class FrogJumpDP3  {
    public int frogJump(int[] heights) {
        int n = heights.length;

        // Edge case: If there is only 1 stair, cost is 0 (already there)
        if (n <= 1) return 0;

        // 'prev2' represents the minimum energy to reach step (i-2)
        // Initially, to reach index 0, cost is 0.
        int prev2 = 0;

        // 'prev1' represents the minimum energy to reach step (i-1)
        // Initially, to reach index 1, cost is abs(heights[1] - heights[0])
        int prev1 = Math.abs(heights[1] - heights[0]);

        // Start calculating from the 2nd index (3rd step) up to n-1
        for (int i = 2; i < n; i++) {
            // Option 1: Jump 1 step from the previous step
            int jumpOne = prev1 + Math.abs(heights[i] - heights[i - 1]);

            // Option 2: Jump 2 steps from the step before previous
            int jumpTwo = prev2 + Math.abs(heights[i] - heights[i - 2]);

            // Take the minimum cost to reach current step 'i'
            int current = Math.min(jumpOne, jumpTwo);

            // Shift pointers for the next iteration
            prev2 = prev1;
            prev1 = current;
        }

        // 'prev1' now holds the cost to reach the last step (n-1)
        return prev1;
    }
}
