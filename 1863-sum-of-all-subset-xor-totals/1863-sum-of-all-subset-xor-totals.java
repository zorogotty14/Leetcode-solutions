class Solution {
    public int subsetXORSum(int[] nums) {
        return calculateSubsetXORSum(nums, 0, 0);
    }
    
    // Using backtracking to generate all subsets and calculate their XOR totals
    private int calculateSubsetXORSum(int[] nums, int index, int currentXOR) {
        // Base case: when we've processed all elements
        if (index == nums.length) {
            return currentXOR;
        }
        
        // For each element, we have two choices:
        // 1. Include the current element in XOR calculation
        int includeCurrentElement = calculateSubsetXORSum(nums, index + 1, currentXOR ^ nums[index]);
        
        // 2. Exclude the current element from XOR calculation
        int excludeCurrentElement = calculateSubsetXORSum(nums, index + 1, currentXOR);
        
        // Return the sum of both choices
        return includeCurrentElement + excludeCurrentElement;
    }
}