import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            boolean exploded = false;
            // Handle collision cases
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    // The top of the stack (moving right) is smaller and explodes
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                    // Both asteroids are equal in size, both explode
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    // The top of the stack (moving right) is larger, the current asteroid explodes
                    exploded = true;
                    break;
                }
            }
            // If the asteroid did not explode, add it to the stack
            if (!exploded) {
                stack.push(asteroid);
            }
        }
        
        // Convert the stack to an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
