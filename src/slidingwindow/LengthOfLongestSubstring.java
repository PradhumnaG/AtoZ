package slidingwindow;

import java.util.HashSet;
import java.util.Set;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if( s.length() == 0||s == null) return 0;
        int i = 0,j = 0, max = 0,n = s.length();
        Set<Character> set = new HashSet<>();
        while(i < n){
            char c = s.charAt(i);
            while(set.contains(c)){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(c);
            max = Math.max(max,i-j+1);
            i++;
        }
        return max;
    }
}