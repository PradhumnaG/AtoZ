package dinamicprogramming;

 class UniquePathtwo  {
    int [][] grid;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.grid = obstacleGrid;
        return result(0,0);
    }
    private int result(int row,int col){
        if(row >= grid.length  || col >= grid[0].length) return 0;
        if(grid[row][col] == 1) return 0;
        if(row == grid.length -1 && col == grid[0].length -1) return 1;
        int down = result(row +1,col);
        int right = result(row,col +1);
        return down + right;
    }
}
