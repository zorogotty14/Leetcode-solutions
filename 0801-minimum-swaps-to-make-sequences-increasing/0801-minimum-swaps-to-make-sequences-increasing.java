class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // Initialize keep and swap for the first element
        int keep = 0;
        int swap = 1;
        
        for (int i = 1; i < n; i++) {
            int prevKeep = keep, prevSwap = swap;
            keep = swap = Integer.MAX_VALUE;
            
            // Case 1: Both arrays already strictly increasing without swap
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                keep = Math.min(keep, prevKeep);
                swap = Math.min(swap, prevSwap + 1);
            }
            
            // Case 2: Arrays strictly increasing after a swap
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                keep = Math.min(keep, prevSwap);
                swap = Math.min(swap, prevKeep + 1);
            }
        }
        
        return Math.min(keep, swap);
    }
}
