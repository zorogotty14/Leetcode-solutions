class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int third = Integer.MIN_VALUE; // This will store the 'nums[k]' part of the pattern
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of possible 'nums[j]'
        
        // Traverse from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            // Check if the current element is the 'nums[i]' part of the 132 pattern
            if (nums[i] < third) {
                return true;
            }
            
            // Keep updating 'third' as long as we can find valid 'nums[k]' candidates
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }
            
            // Push the current number onto the stack as a candidate for 'nums[j]'
            stack.push(nums[i]);
        }
        
        // No 132 pattern found
        return false;
    }
}
