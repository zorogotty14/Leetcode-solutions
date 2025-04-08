class Solution {
    public int minimumOperations(int[] nums) {
    int operations = 0;
    int i = 0;
    
    while (i < nums.length) {
        // If the remaining elements are distinct, we're done
        if (hasDistinctElements(nums, i)) {
            return operations;
        }
        
        // Remove 3 elements (or remaining elements if fewer than 3)
        i += Math.min(3, nums.length - i);
        operations++;
    }
    
    return operations;
}

// Helper method to check if elements from startIndex to the end are distinct
private boolean hasDistinctElements(int[] nums, int startIndex) {
    Set<Integer> set = new HashSet<>();
    
    for (int i = startIndex; i < nums.length; i++) {
        if (set.contains(nums[i])) {
            return false;
        }
        set.add(nums[i]);
    }
    
    return true;
}
}