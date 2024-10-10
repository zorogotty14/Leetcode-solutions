class Solution {
    public int maxWidthRamp(int[] nums) {
        // Stack to store indices where nums is decreasing
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Build a decreasing stack
        for (int i = 0; i < nums.length; i++) {
            // Push the index onto the stack if it's a decreasing element
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        
        // Step 2: Traverse from the right to find the maximum ramp width
        int maxWidth = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            // While there is a valid ramp (nums[stack.peek()] <= nums[j]), compute the width
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                int i = stack.pop();
                maxWidth = Math.max(maxWidth, j - i);
            }
        }
        
        return maxWidth;
    }
}
