import java.util.*;

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> resultSet = new HashSet<>();
        
        // Step 1: Find all indices j where nums[j] == key
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == key) {
                // Step 2: Add all i such that |i - j| <= k
                int start = Math.max(0, j - k);
                int end = Math.min(nums.length - 1, j + k);
                
                for (int i = start; i <= end; i++) {
                    resultSet.add(i);
                }
            }
        }

        // Step 3: Convert to list and sort
        List<Integer> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
}
