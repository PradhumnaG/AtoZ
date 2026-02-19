package dinamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class PartionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> nextDP = new HashSet<>();

            for (int t : dp) {
                if (t + nums[i] == target) {
                    return true;
                }
                nextDP.add(t);
                nextDP.add(t + nums[i]);
            }
            dp = nextDP;
        }
        return dp.contains(target);

    }
}
