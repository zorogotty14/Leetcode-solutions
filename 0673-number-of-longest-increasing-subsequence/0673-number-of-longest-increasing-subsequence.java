class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] length = new int[n];
        int[] count = new int[n];
        
        // Initialize all lengths to 1 and counts to 1 for each position
        for (int i = 0; i < n; i++) {
            length[i] = 1;
            count[i] = 1;
        }
        
        int maxLength = 0;
        
        // Build length and count arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) { // Check if it's an increasing subsequence
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
            // Update maxLength with the longest found so far
            maxLength = Math.max(maxLength, length[i]);
        }
        
        int result = 0;
        // Sum up counts for the longest increasing subsequences
        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                result += count[i];
            }
        }
        
        return result;
    }
}
