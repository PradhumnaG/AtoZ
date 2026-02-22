package dinamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class TaegetSum {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();

        // Base case: 1 way to make a sum of 0 using 0 elements
        dp.put(0, 1);

        for (int num : nums) {

            Map<Integer, Integer> nextDp = new HashMap<>();


            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int currentSum = entry.getKey();
                int count = entry.getValue();


                int addSum = currentSum + num;
                nextDp.put(addSum, nextDp.getOrDefault(addSum, 0) + count);


                int subSum = currentSum - num;
                nextDp.put(subSum, nextDp.getOrDefault(subSum, 0) + count);
            }


            dp = nextDp;
        }

        return dp.getOrDefault(target, 0);

    }
}
