import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        // Mark numbers as negative to indicate presence
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1; // Get index corresponding to the value
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Mark as negative
            }
        }

        // Collect numbers that are still positive (indices + 1)
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // Missing number
            }
            // Optional: Restore original values if needed
            // else {
            //     nums[i] = -nums[i]; // Restore original value
            // }
        }

        return result;
    }
}
