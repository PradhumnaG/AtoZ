package recurssion.recurssionOne;

public class SubsequenceSum {

    // Main recursive function to count subsequences
    public static int countSubsequences(int[] nums, int index, int target) {
        // Base Case 1: If target is 0, we found a valid subsequence sum
        if (target == 0) {
            return 1;
        }

        // Base Case 2: If we processed all elements or target becomes negative
        if (index == nums.length || target < 0) {
            return 0;
        }

        // Option 1: Pick the current element
        // Subtract nums[index] from the target and move to the next index
        int pick = countSubsequences(nums, index + 1, target - nums[index]);

        // Option 2: Don't pick the current element
        // Keep target the same and move to the next index
        int notPick = countSubsequences(nums, index + 1, target);

        // Return total count from both options
        return pick + notPick;
    }

    public static void main(String[] args) {
        int[] nums = {1, 10, 4, 5};
        int k = 16;

        int result = countSubsequences(nums, 0, k);

        System.out.println("Input: nums = [1, 10, 4, 5] , k = 16");
        System.out.println("Output: " + result);

        // Example 1 Test
        int[] nums2 = {4, 9, 2, 5, 1};
        int k2 = 10;
        System.out.println("Test Example 1 Output: " + countSubsequences(nums2, 0, k2)); // Should be 2
    }
}
