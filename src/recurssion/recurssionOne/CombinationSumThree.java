package recurssion.recurssionOne;

import java.util.ArrayList;
import java.util.List;

class CombinationSumThree
{
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        sol(all,temp,k,n,1);
        return  all;

    }
    private void sol(List<List<Integer>> all,List<Integer> temp,int k,int n,int start){
        if(temp.size() == k){
            if( n == 0){
                all.add(new ArrayList<>(temp));
            }
            return;

        }
        for(int i = start;i <= 9; i++){
            if (i > n) break;
            temp.add(i);
            sol(all,temp,k,n - i,i +1);
            temp.remove(temp.size() - 1);
        }
    }
}
