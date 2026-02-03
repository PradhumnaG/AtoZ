package recurssion.recurssionOne;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with empty dots
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Branch and Bound Arrays (The "Pepcoding" Optimization)
        boolean[] cols = new boolean[n];
        boolean[] normalDiag = new boolean[2 * n - 1]; // For diagonals: / (row + col)
        boolean[] reverseDiag = new boolean[2 * n - 1]; // For diagonals: \ (row - col + n - 1)

        solve(board, 0, cols, normalDiag, reverseDiag, ans);
        return ans;
    }

    private void solve(char[][] board, int row, boolean[] cols, boolean[] normalDiag, boolean[] reverseDiag, List<List<String>> ans) {
        // Base Case: If all rows are filled, we found a solution
        if (row == board.length) {
            ans.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            // Formula from video for indices:
            // Normal Diagonal (/) -> row + col
            // Reverse Diagonal (\) -> row - col + board.length - 1

            if (!cols[col] && !normalDiag[row + col] && !reverseDiag[row - col + board.length - 1]) {

                // 1. Place Queen and Mark Arrays (Branch)
                board[row][col] = 'Q';
                cols[col] = true;
                normalDiag[row + col] = true;
                reverseDiag[row - col + board.length - 1] = true;

                // 2. Recurse to next row
                solve(board, row + 1, cols, normalDiag, reverseDiag, ans);

                // 3. Remove Queen and Unmark Arrays (Backtrack)
                board[row][col] = '.';
                cols[col] = false;
                normalDiag[row + col] = false;
                reverseDiag[row - col + board.length - 1] = false;
            }
        }
    }

    // Helper to convert char board to List<String> format
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
