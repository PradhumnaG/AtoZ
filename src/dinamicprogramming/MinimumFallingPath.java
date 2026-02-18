package dinamicprogramming;

public class MinimumFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prevDP = new int[m];
        for (int j = 0; j < m; j++) {
            prevDP[j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            int[] currDP = new int[m];
            for (int j = 0; j < m; j++) {
                int minPrev = prevDP[j];
                if (j > 0) {
                    minPrev = Math.min(minPrev, prevDP[j - 1]);
                }
                if (j < m - 1) {
                    minPrev = Math.min(minPrev, prevDP[j + 1]);
                }
                currDP[j] = matrix[i][j] + minPrev;
            }
            prevDP = currDP;
        }
        int minSum = Integer.MAX_VALUE;
        for (int val : prevDP) {
            minSum = Math.min(minSum, val);
        }

        return minSum;


    }
}
