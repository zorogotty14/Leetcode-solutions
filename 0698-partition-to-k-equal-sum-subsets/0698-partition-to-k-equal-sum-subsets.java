import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % k != 0) {
            return false;  // If totalSum cannot be evenly divided by k, return false
        }

        int target = totalSum / k;  // Each subset must sum to this value
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > target) {
            return false;  // If the largest element is greater than target, return false
        }

        boolean[] used = new boolean[n];
        return backtrack(nums, used, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] used, int k, int startIndex, int currentSum, int target) {
        if (k == 0) {
            return true;  // All subsets are successfully formed
        }
        if (currentSum == target) {
            // Move on to form the next subset
            return backtrack(nums, used, k - 1, 0, 0, target);
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (used[i] || currentSum + nums[i] > target) {
                continue;  // Skip used elements or sums that exceed the target
            }

            // Choose the element
            used[i] = true;
            if (backtrack(nums, used, k, i + 1, currentSum + nums[i], target)) {
                return true;
            }
            // Undo the choice
            used[i] = false;
        }

        return false;  // No valid subset arrangement found
    }
}
