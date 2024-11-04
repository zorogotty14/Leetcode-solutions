import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        
        for (String op : operations) {
            if (op.equals("+")) {
                // "+" operation: sum of the last two scores
                int top = stack.pop();
                int newScore = top + stack.peek();
                stack.push(top); // Push the previous top back
                stack.push(newScore); // Add the new score
            } else if (op.equals("D")) {
                // "D" operation: double of the last score
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                // "C" operation: remove the last score
                stack.pop();
            } else {
                // Integer operation: add the score to the stack
                stack.push(Integer.parseInt(op));
            }
        }
        
        // Sum all elements in the stack
        int totalSum = 0;
        for (int score : stack) {
            totalSum += score;
        }
        
        return totalSum;
    }
}
