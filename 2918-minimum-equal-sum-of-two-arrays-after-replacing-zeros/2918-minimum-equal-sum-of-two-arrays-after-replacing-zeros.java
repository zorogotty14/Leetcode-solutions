class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0; // Current sum of nums1
        long sum2 = 0; // Current sum of nums2
        int zeros1 = 0; // Count of zeros in nums1
        int zeros2 = 0; // Count of zeros in nums2
        
        // Calculate current sums and count zeros
        for (int num : nums1) {
            sum1 += num;
            if (num == 0) zeros1++;
        }
        
        for (int num : nums2) {
            sum2 += num;
            if (num == 0) zeros2++;
        }
        
        // Minimum possible values after replacing zeros
        // (each zero must be replaced with at least 1)
        long minPossibleSum1 = sum1 + zeros1;
        long minPossibleSum2 = sum2 + zeros2;
        
        // Case 1: If current sums are equal and no zeros in either array
        if (sum1 == sum2 && zeros1 == 0 && zeros2 == 0) {
            return sum1; // Already equal, no changes needed
        }
        
        // Case 2: If no zeros in nums1, then sum1 is fixed
        if (zeros1 == 0) {
            // If sum1 < minPossibleSum2, we can't make them equal
            if (sum1 < minPossibleSum2) {
                return -1;
            }
            // We can only increase sum2 by replacing zeros
            return sum1;
        }
        
        // Case 3: If no zeros in nums2, then sum2 is fixed
        if (zeros2 == 0) {
            // If sum2 < minPossibleSum1, we can't make them equal
            if (sum2 < minPossibleSum1) {
                return -1;
            }
            // We can only increase sum1 by replacing zeros
            return sum2;
        }
        
        // Case 4: Both arrays have zeros, we need to find the minimum equal sum
        return Math.max(minPossibleSum1, minPossibleSum2);
    }
}