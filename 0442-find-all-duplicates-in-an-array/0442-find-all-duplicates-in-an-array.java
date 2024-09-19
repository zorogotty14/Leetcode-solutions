import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1; // Get the index corresponding to the value
            
            if (nums[idx] < 0) {
                // The number at this index is negative, so we've seen it before
                res.add(Math.abs(nums[i]));
            } else {
                // Mark the number as seen by negating the element at nums[idx]
                nums[idx] = -nums[idx];
            }
        }
        
        // Optional: Restore the original array if needed
        // for(int i = 0; i < nums.length; i++) {
        //     nums[i] = Math.abs(nums[i]);
        // }
        
        return res;
    }
}
