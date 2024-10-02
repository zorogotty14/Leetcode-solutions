import java.util.*;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> current = new ArrayList<>();
        backtrack(nums, 0, current, result);
        return new ArrayList<>(result);
    }
    
    private void backtrack(int[] nums, int index, List<Integer> current, Set<List<Integer>> result) {
        // If the current subsequence has at least 2 elements, add it to the result set
        if (current.size() >= 2) {
            result.add(new ArrayList<>(current));
        }
        
        // Explore all possibilities by including elements from the index onward
        for (int i = index; i < nums.length; i++) {
            // Only add the current element if it maintains the non-decreasing order
            if (current.isEmpty() || nums[i] >= current.get(current.size() - 1)) {
                current.add(nums[i]);
                backtrack(nums, i + 1, current, result);
                // Backtrack by removing the last element to try other combinations
                current.remove(current.size() - 1);
            }
        }
    }
}
