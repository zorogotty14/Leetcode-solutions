class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // DP arrays to store LIS and LDS
        int[] lis = new int[n];
        int[] lds = new int[n];
        
        // Initialize all elements with 1 (each element is an increasing sequence of length 1)
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            lds[i] = 1;
        }
        
        // Compute LIS for every element
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Compute LDS for every element
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Find the maximum length of a valid mountain array
        int maxMountainLength = 0;
        for (int i = 1; i < n - 1; i++) {  // Peak can't be the first or last element
            if (lis[i] > 1 && lds[i] > 1) {  // Valid peak
                maxMountainLength = Math.max(maxMountainLength, lis[i] + lds[i] - 1);
            }
        }

        // Minimum removals to make the mountain array
        return n - maxMountainLength;
    }
}
