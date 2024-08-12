class Solution {
    public int maxProduct(int[] nums) {
        // Initialize the maximum, minimum products, and the final result
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = nums[0];
        
        // Traverse through the array, starting from the second element
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            
            // If the current number is negative, swap max and min
            if (current < 0) {
                int temp = max_so_far;
                max_so_far = min_so_far;
                min_so_far = temp;
            }
            
            // Calculate the max/min products for the current position
            max_so_far = Math.max(current, max_so_far * current);
            min_so_far = Math.min(current, min_so_far * current);
            
            // Update the result with the maximum product found so far
            result = Math.max(result, max_so_far);
        }
        
        return result;
    }
}
