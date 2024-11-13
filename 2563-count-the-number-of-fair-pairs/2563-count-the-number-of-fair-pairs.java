import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // Sort the input array
        Arrays.sort(nums);
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            // Find the range [lower - nums[i], upper - nums[i]] using binary search
            int left = binarySearchLeft(nums, i + 1, nums.length - 1, lower - nums[i]);
            int right = binarySearchRight(nums, i + 1, nums.length - 1, upper - nums[i]);

            if (left != -1 && right != -1 && left <= right) {
                count += (right - left + 1);
            }
        }
        return count;
    }

    private int binarySearchLeft(int[] nums, int start, int end, int target) {
        int low = start, high = end, res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private int binarySearchRight(int[] nums, int start, int end, int target) {
        int low = start, high = end, res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
