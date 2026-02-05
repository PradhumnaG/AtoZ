package slidingwindow;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j=0,n =nums.length;
        while(i < n){
            if(nums[i] == 0)  k--;
            if(k<0){
                if(nums[j] == 0){
                    k++;
                }
                j++;
            }
            i++;
        }
        return i - j;
    }
}
