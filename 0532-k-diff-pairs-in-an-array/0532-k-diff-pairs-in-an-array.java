import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0; // Absolute difference can't be negative
        }
        
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;
        
        // Build frequency map
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for (int num : freqMap.keySet()) {
            if (k == 0) {
                // If k is 0, count the number of elements that appear more than once
                if (freqMap.get(num) > 1) {
                    count++;
                }
            } else {
                // If k is positive, check if num + k exists
                if (freqMap.containsKey(num + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
