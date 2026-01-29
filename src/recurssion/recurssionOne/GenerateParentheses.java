package recurssion.recurssionOne;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    // Main function expected by LeetCode
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // We start with an empty StringBuilder, 0 open, and 0 closed parentheses
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    // Helper function for Backtracking
    private void backtrack(List<String> result, StringBuilder current, int openN, int closedN, int n) {
        // Base Case: If we have n open and n closed, the sequence is complete and valid
        if (openN == n && closedN == n) {
            result.add(current.toString());
            return;
        }


        // Condition: We can only add '(' if we haven't used all n yet
        if (openN < n) {
            current.append("(");
            backtrack(result, current, openN + 1, closedN, n);
            current.deleteCharAt(current.length() - 1); // Pop/Backtrack
        }

        // Decision 2: Add a close parenthesis ')'
        // Condition: We can only add ')' if we have more open ones than closed ones
        if (closedN < openN) {
            current.append(")");
            backtrack(result, current, openN, closedN + 1, n);
            current.deleteCharAt(current.length() - 1); // Pop/Backtrack
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        int n = 3;
        List<String> output = solution.generateParenthesis(n);

        System.out.println("Generate Parentheses for n = " + n + ":");
        System.out.println(output);
        // Expected Output: ["((()))","(()())","(())()","()(())","()()()"]
    }
}
