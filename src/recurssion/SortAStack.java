package recurssion;

import java.util.Stack;

class SortAStack {
    // Main method to sort the stack
    public void sortStack(Stack<Integer> s) {
        // Base case: If stack is empty, return
        if (s.isEmpty()) {
            return;
        }

        // Step 1: Remove the top element
        int top = s.pop();

        // Step 2: Recursively sort the remaining stack
        sortStack(s);

        // Step 3: Insert the popped element back in the correct position
        sortedInsert(s, top);
    }

    // Helper method to insert an element into a sorted stack
    private void sortedInsert(Stack<Integer> s, int element) {
        // Base case: If stack is empty or top element is smaller than the new element
        // (Change '<=' to '>=' if you want the reverse sort order)
        if (s.isEmpty() || s.peek() <= element) {
            s.push(element);
            return;
        }

        // Step 1: Remove the top element to find the correct spot
        int temp = s.pop();

        // Step 2: Recursive call to insert the element deeper
        sortedInsert(s, element);

        // Step 3: Put the top element back
        s.push(temp);
    }
}
