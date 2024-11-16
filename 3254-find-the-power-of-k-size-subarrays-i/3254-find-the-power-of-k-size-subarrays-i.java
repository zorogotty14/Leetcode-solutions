class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1]; // Result array

        for (int i = 0; i <= n - k; i++) {
            boolean isConsecutive = true;
            int maxElement = nums[i];
            
            // Check if the elements in the subarray are consecutive and sorted
            for (int j = i; j < i + k - 1; j++) {
                if (nums[j + 1] != nums[j] + 1) {
                    isConsecutive = false;
                    break;
                }
                maxElement = Math.max(maxElement, nums[j + 1]);
            }
            
            // Set the result based on the condition
            results[i] = isConsecutive ? maxElement : -1;
        }

        return results;
    }
}
