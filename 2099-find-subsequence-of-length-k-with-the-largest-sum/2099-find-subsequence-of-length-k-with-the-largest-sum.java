class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        
        // Create array of indices paired with values
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Sort indices by values in descending order
        // If values are equal, maintain original order (stable sort)
        Arrays.sort(indices, (i, j) -> {
            if (nums[i] != nums[j]) {
                return Integer.compare(nums[j], nums[i]); // descending by value
            }
            return Integer.compare(i, j); // ascending by index for stability
        });
        
        // Take first k indices (corresponding to k largest values)
        Integer[] selectedIndices = new Integer[k];
        for (int i = 0; i < k; i++) {
            selectedIndices[i] = indices[i];
        }
        
        // Sort selected indices to maintain original order
        Arrays.sort(selectedIndices);
        
        // Build result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[selectedIndices[i]];
        }
        
        return result;
    }
}