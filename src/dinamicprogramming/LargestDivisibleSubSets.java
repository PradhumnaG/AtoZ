package dinamicprogramming;

 import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubSets {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();

        // Step 1: Sort the array (Explained at [05:25])
        // Sorting ensures that if a % b == 0 and b % c == 0, then a % c == 0        Arrays.sort(nums)

        // dp[i] stores the length of the largest divisible subset ending at index i
        int[] dp = new int[n];
        // hash[i] stores the previous index in the subset to reconstruct the path
        int[] hash = new int[n];

        // Initialize dp array to 1 (every element is a subset of size 1)
        Arrays.fill(dp, 1);

        // Initialize hash array so each element points to itself initially
        for (int i = 0; i < n; i++) {
            hash[i] = i;
        }

        int maxLen = 1;
        int lastIndex = 0;

        // Step 2: Nested Loop (Standard LIS Logic) (Explained at [09:16])
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check divisibility and if extending the subset increases length
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j; // Keep track of the previous index
                }
            }

            // Track the maximum length and the index where it ends
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        // Step 3: Reconstruct the path using the hash array (Explained at [12:45])
        List<Integer> result = new ArrayList<>();
        result.add(nums[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            result.add(nums[lastIndex]);
        }

        // The order doesn't matter for the answer, but usually, we return it sorted
        // The loop builds it backwards (largest to smallest), so we can reverse it if needed.
        // However, the problem accepts any order.
        Collections.reverse(result);

        return result;
    }
}
