package dinamicprogramming;


import java.util.Arrays;

public class CheckIfKExist  {
    public static boolean subsetSumToK(int n, int k, int[] arr) {
        // Create an array to store the results of the previous row
        // Size is k + 1 because we need indices from 0 to k
        // [09:06]
        boolean[] prev = new boolean[k + 1];

        // Base Case 1: If target is 0, the answer is always true (empty subsequence)
        // [09:21]
        prev[0] = true;

        // Base Case 2: For the first index (0), if the element equals the target, it's true.
        // We must check if arr[0] is within bounds of k.
        // [09:21]
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        // Iterate through the remaining elements (from index 1 to n-1)
        // [09:48]
        for (int i = 1; i < n; i++) {
            boolean[] curr = new boolean[k + 1];

            // For every row, target 0 is always possible (empty set)
            // [09:30]
            curr[0] = true;

            for (int target = 1; target <= k; target++) {
                // Option 1: Skip the current element (take result from previous row)
                boolean notTake = prev[target];

                // Option 2: Pick the current element (if it's less than or equal to target)
                // We check if we could achieve the remaining target (target - arr[i]) previously
                boolean take = false;
                if (arr[i] <= target) {
                    take = prev[target - arr[i]];
                }

                // If either option works, the answer is true
                curr[target] = take || notTake;
            }

            // Move current row to previous row for the next iteration
            // [09:54]
            prev = curr;
        }

        // The answer is stored in the last cell of the array
        // [09:59]
        return prev[k];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 4;
        int n = arr.length;

        if (subsetSumToK(n, k, arr)) {
            System.out.println("Subset with sum " + k + " exists.");
        } else {
            System.out.println("Subset with sum " + k + " does not exist.");
        }
    }
}