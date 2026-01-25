package recurssion.recurssionOne;

import java.util.Stack;

class ReverseStack {

    // Main method to reverse the stack
    public void reverse(Stack<Integer> s) {
        // Base case: If stack is empty, return
        if (s.isEmpty()) {
            return;
        }

        // Step 1: Remove the top element
        int top = s.pop();

        // Step 2: Recursively reverse the remaining stack
        reverse(s);

        // Step 3: Insert the popped element at the BOTTOM of the reversed stack
        insertAtBottom(s, top);
    }

    // Helper method to insert an element at the very bottom of the stack
    private void insertAtBottom(Stack<Integer> s, int element) {
        // Base case: If stack is empty, we found the bottom. Push the element here.
        if (s.isEmpty()) {
            s.push(element);
            return;
        }

        // Step 1: Remove the top element to access deeper layers
        int top = s.pop();

        // Step 2: Recursive call to keep going down
        insertAtBottom(s, element);

        // Step 3: Put the top element back on top of the new element
        s.push(top);
    }
}}
