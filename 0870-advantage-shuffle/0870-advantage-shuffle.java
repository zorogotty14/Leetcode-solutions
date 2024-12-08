import java.util.*;

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // Step 1: Sort nums1
        Arrays.sort(nums1);
        
        // Step 2: Pair nums2 with their indices and sort by value
        int n = nums2.length;
        int[][] nums2WithIndices = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums2WithIndices[i][0] = nums2[i]; // value
            nums2WithIndices[i][1] = i;       // original index
        }
        Arrays.sort(nums2WithIndices, (a, b) -> Integer.compare(a[0], b[0])); // Sort by value
        
        // Step 3: Use a greedy two-pointer approach
        int[] result = new int[n];
        int left = 0, right = n - 1; // Pointers for nums2WithIndices
        for (int num : nums1) {
            if (num > nums2WithIndices[left][0]) {
                // Advantageous case: num beats the smallest element in nums2
                result[nums2WithIndices[left][1]] = num;
                left++;
            } else {
                // Non-advantageous case: use num against the largest remaining element
                result[nums2WithIndices[right][1]] = num;
                right--;
            }
        }
        
        return result;
    }
}
