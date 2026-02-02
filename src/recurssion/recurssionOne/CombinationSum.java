package recurssion.recurssionOne;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        fun(all,al,target,candidates,0);
        return all;
    }

    public  static void fun(List<List<Integer>> all,List<Integer> al,int target,int [] candidates,int idx) {
        if(target == 0){
            all.add(new ArrayList<>(al));
            return;
        }
        for(int i = idx;i<candidates.length;i++){
            if(candidates[i] <= target){
                al.add(candidates[i]);
                fun(all,al, target - candidates[i],candidates,i);
                al.remove(al.size() - 1);

            }

        }


    }
}
