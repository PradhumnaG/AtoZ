package dinamicprogramming;

public class LongesCommonSubsequence  {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // dp[i][j] will store the length of the LCS of text1[0..i-1] and text2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Iterate through each character of both strings
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // If characters match, add 1 to the result of the sequences without these characters
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                // If they don't match, take the maximum from skipping either one character or the other
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The bottom-right cell contains the length of the LCS for the full strings
        return dp[m][n];
    }
}
