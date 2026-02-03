package recurssion.recurssionOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LettersCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        backtrack(hm,ans,new StringBuilder(),0,digits);
        return ans;
    }
    private void backtrack(HashMap<Character,String> hm,List<String>ans,StringBuilder sb, int i,String digits){
        if( i == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String curr = hm.get(digits.charAt(i)) ;
        for(int k = 0;k < curr.length();k++){
            sb.append(curr.charAt(k));
            backtrack(hm,ans,sb,i + 1,digits);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
