package dinamicprogramming;

 class HouseRobberySecond  {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int max1 = re1(nums,0,n-2);
        int max2 = re1(nums,1,n-1);
        int max = Math.max(max1,max2);
        return max;
    }
    public int re1(int[] nums,int start, int end){
        int prev1 = 0,prev2 = 0;
        for(int i= start;i<=end;i++){
            int current = Math.max(prev2 +nums[i],prev1);
            prev2 = prev1;
            prev1 = current;
        }//
        return prev1;
    }
}
