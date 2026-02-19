package dinamicprogramming;

import java.util.Arrays;

public class NumberOfSubsequenceThatSatisfyTheSum {
        public int numSubseq(int[] nums, int target) {
            int n = nums.length;
            int mod = 1_000_000_007;


            int[] powerOf2 = new int[n];
            powerOf2[0] = 1;
            for (int i = 1; i < n; i++) {
                powerOf2[i] = (powerOf2[i - 1] * 2) % mod;
            }


            Arrays.sort(nums);

            int count = 0;
            int left = 0;
            int right = n - 1;


            while (left <= right) {
                if (nums[left] + nums[right] > target) {

                    right--;
                } else {

                    count = (count + powerOf2[right - left]) % mod;
                    left++;
                }
            }

            return count;

        }

}
