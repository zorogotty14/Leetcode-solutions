class Solution {
    public int minimumIndex(List<Integer> nums) {
        // Find the dominant element in the entire array
        int dominant = findDominantElement(nums);
        
        // Count total occurrences of dominant element
        int totalDominantCount = 0;
        for (int num : nums) {
            if (num == dominant) {
                totalDominantCount++;
            }
        }
        
        // Track occurrences in left subarray
        int leftDominantCount = 0;
        
        // Check each possible split
        for (int i = 0; i < nums.size() - 1; i++) {
            // Update left dominant count if we find the dominant element
            if (nums.get(i) == dominant) {
                leftDominantCount++;
            }
            
            // Calculate right dominant count
            int rightDominantCount = totalDominantCount - leftDominantCount;
            
            // Check if left and right subarrays have valid dominant element
            if (leftDominantCount * 2 > (i + 1) && 
                rightDominantCount * 2 > (nums.size() - i - 1)) {
                return i;
            }
        }
        
        // No valid split found
        return -1;
    }
    
    // Find the dominant element using Boyer-Moore Voting Algorithm
    private int findDominantElement(List<Integer> nums) {
        int candidate = nums.get(0);
        int count = 1;
        
        for (int i = 1; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count = 1;
            } else if (nums.get(i) == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}