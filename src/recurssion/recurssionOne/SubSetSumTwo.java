package recurssion.recurssionOne;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubSetSumTwo{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        extracted(nums);
        solve(result,new ArrayList<>(),nums,0);
        return result;
    }

    private static void extracted(int[] nums) {
        Arrays.sort(nums);
    }

    private void solve(List<List<Integer>> result,List<Integer>sus,int[]nums,int idx){
        if(result.contains(sus)){
            return;
        }
        result.add(new ArrayList<>(sus));
        for(int i = idx;i < nums.length;i++){
            sus.add(nums[i]);
            solve(result,sus,nums,i +1);
            sus.remove(sus.size() - 1);
        }
    }
}
