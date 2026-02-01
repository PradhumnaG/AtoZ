package recurssion.recurssionOne;

public class CheckSubsequenceSum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Should be true (1 + 3 + 5 = 9) -> actually (4+5=9) or (1+3+5=9)??
        // Example: {1, 2, 1}, k=3 -> True (1+2)
        int[] nums1 = {1, 2, 1};
        int k1 = 3;
        System.out.println("Test Case 1: " + solution.checkSubsequenceSum(nums1, k1)); // Expected: true

        // Test Case 2: Should be false
        int[] nums2 = {1, 2, 3};
        int k2 = 7;
        System.out.println("Test Case 2: " + solution.checkSubsequenceSum(nums2, k2)); // Expected: false

        // Test Case 3: Should be true (5 + 5 = 10)
        int[] nums3 = {5, 1, 5, 2};
        int k3 = 10;
        System.out.println("Test Case 3: " + solution.checkSubsequenceSum(nums3, k3)); // Expected: true
    }
}

class Solution {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        int sum = 0;
        // Start recursion from index 0 and current sum 0
        return solve(0, sum, nums, k);
    }

    // Helper recursive function
    boolean solve(int idx, int sum, int[] nums, int k) {
        // Base Case 1: If current sum matches target k, we found a subsequence
        if (sum == k) {
            return true;
        }

        // Optimization: If sum exceeds k, stop (Assuming input numbers are positive)
        if (sum > k) {
            return false;
        }

        // Base Case 2: If we reached the end of the array without finding sum
        if (idx == nums.length) {
            return false;
        }

        // Recursive Step:
        // 1. Take: Include the current element in the sum
        boolean take = solve(idx + 1, sum + nums[idx], nums, k);

        // Optimization: If 'take' already found a solution, return true immediately.
        // This prevents checking the 'notTake' branch unnecessarily.
        if (take == true) {
            return true;
        }

        // 2. Not Take: Exclude the current element from the sum
        boolean notTake = solve(idx + 1, sum, nums, k);

        return take || notTake;
    }
}
