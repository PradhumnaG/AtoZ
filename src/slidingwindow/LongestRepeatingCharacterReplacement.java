package slidingwindow;

 class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n =s.length();
        int S =0,Mc=0,Ml=0;
        int[] CA = new int[26];
        for( int E =0;E<n;E++){
            CA[s.charAt(E)-'A']++;
            int CCA = CA[s.charAt(E)-'A'];
            Mc = Math.max(Mc,CCA);
            if(E - S + 1 -Mc > k){
                CA[s.charAt(S)-'A']--;
                S++;
            }
            Ml = Math.max(Ml,E-S+1);
        }
        return Ml;

    }
}
