package dinamicprogramming;

 class MinimumPathM  {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 1. Initialize the First Row
        // You can only come from the left, so just add the previous value.
        for (int i = 1; i < cols; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        // 2. Initialize the First Column
        // You can only come from the top, so just add the previous value.
        for (int j = 1; j < rows; j++) {
            grid[j][0] += grid[j - 1][0];
        }

        // 3. Fill the rest of the grid
        // For every other cell, check if it's cheaper to come from the Top or the Left.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        // The bottom-right cell now contains the minimum path sum
        return grid[rows - 1][cols - 1];
    }
}
