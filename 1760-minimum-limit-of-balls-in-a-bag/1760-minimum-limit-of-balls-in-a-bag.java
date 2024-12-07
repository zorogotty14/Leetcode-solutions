class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        // Binary search range for the penalty
        int left = 1, right = Integer.MIN_VALUE;
        for (int num : nums) {
            right = Math.max(right, num); // Maximum balls in any bag
        }
        
        int result = right; // Store the minimum possible penalty
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Current penalty to check
            
            if (canDivide(nums, maxOperations, mid)) {
                result = mid; // Update the result if feasible
                right = mid - 1; // Try for a smaller penalty
            } else {
                left = mid + 1; // Try for a larger penalty
            }
        }
        
        return result;
    }
    
    private boolean canDivide(int[] nums, int maxOperations, int penalty) {
        int operations = 0;
        for (int num : nums) {
            // Calculate required operations for the current penalty
            operations += (num - 1) / penalty;
            if (operations > maxOperations) {
                return false; // Exceeds allowed operations
            }
        }
        return true; // Feasible with the given operations
    }
}
