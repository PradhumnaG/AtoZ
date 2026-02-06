package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountNumberofNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0, cur = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        for (int num : nums) {
            cur += num % 2;
            res += map.getOrDefault(cur - k, 0);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return res;

    }

}