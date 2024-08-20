import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2) return false;
        
        TreeSet<Long> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Convert nums[i] to long to avoid integer overflow issues
            long num = nums[i];
            
            // Check if there is any number in the set within the valueDiff range
            Long floor = set.floor(num + valueDiff);
            Long ceiling = set.ceiling(num - valueDiff);
            
            if ((floor != null && floor >= num) || (ceiling != null && ceiling <= num)) {
                return true;
            }
            
            // Add the current number to the set
            set.add(num);
            
            // Ensure the set contains only at most indexDiff elements
            if (set.size() > indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        
        return false;
    }
}
