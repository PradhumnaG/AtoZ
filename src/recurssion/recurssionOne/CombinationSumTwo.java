package recurssion.recurssionOne;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CombinationSumTwo {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        Arrays.sort(candidates);
        fun(all, al, candidates, target, 0);
        return all;
    }

    public static void fun(List<List<Integer>> all, List<Integer> al, int[] candidates, int target, int idx) {
        if (target == 0) {
            all.add(new ArrayList<>(al));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }


            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            al.add(candidates[i]);
            fun(all, al, candidates, target - candidates[i], i + 1);
            al.remove(al.size() - 1);


        }
    }
}



