package recurssion.recurssionOne;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSumsOne {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Start recursion from index 0 with current sum 0.
        solve(0, 0, nums, result);

        // Sorting the output is standard for this problem to match test cases
        Collections.sort(result);

        return result;
    }

    // Helper function for recursion
    private void solve(int index, int currentSum, int[] nums, List<Integer> result) {
        // Base Case: If we have processed all elements
        if (index == nums.length) {
            result.add(currentSum);
            return;
        }

        // Choice 1: Pick the element (Add nums[index] to currentSum)
        solve(index + 1, currentSum + nums[index], nums, result);

        // Choice 2: Don't Pick the element (Keep currentSum as is)
        solve(index + 1, currentSum, nums, result);
    }
}
