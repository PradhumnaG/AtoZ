package recurssion.recurssionOne;

class DistinctSubseqII {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        // endsWith[i] stores the count of distinct subsequences ending with the i-th character ('a' -> 0, etc.)
        long[] endsWith = new long[26];
        long total = 0;

        for (char c : s.toCharArray()) {
            int index = c - 'a';

            // Save the previous count of subsequences ending with this character
            long prevCount = endsWith[index];

            // The new count of subsequences ending with 'c' is the total count of
            // all valid subsequences formed so far + 1 (the character 'c' itself).
            endsWith[index] = (total + 1) % MOD;

            // Update total:
            // 1. Add the new sequences ending in 'c'
            // 2. Subtract the old sequences ending in 'c' (duplicates)
            // We add MOD before % to ensure the result is non-negative.
            total = (total + endsWith[index] - prevCount + MOD) % MOD;
        }

        return (int) total;
    }
}
