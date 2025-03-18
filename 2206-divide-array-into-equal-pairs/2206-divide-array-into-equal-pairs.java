class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501]; // Since nums[i] is between 1 and 500
        
        // Count frequency of each number
        for (int num : nums) {
            freq[num]++;
        }
        
        // Check if all numbers have even frequency
        for (int count : freq) {
            if (count % 2 != 0) return false;
        }
        
        return true;
    }
}
