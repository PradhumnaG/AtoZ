package recurssion.recurssionOne;

import java.util.ArrayList;
import java.util.List;

public class PalimdromePartionationing {
    public List<List<String>> partition(String s) {
        List<List<String>> all =new ArrayList<>();
        List<String> al = new ArrayList<>();
        solve(all,al,s);
        return all;
    }
    private void solve(List<List<String>> all,List<String> al,String s){
        if( s.length() == 0){
            all.add(new ArrayList<>(al));
            return;
        }
        for( int  i = 0;i < s.length();i++){
            String part = s.substring(0,i +1);
            if(isPalim(part)){
                al.add(part);
                solve(all,al,s.substring(i +1));
                al.remove(al.size() -1);
            }
        }
    }
    boolean isPalim(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
