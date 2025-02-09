import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long totalPairs = (n * (n - 1)) / 2; // Total possible pairs
        
        Map<Integer, Long> freqMap = new HashMap<>();
        long goodPairs = 0;
        
        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            if (freqMap.containsKey(key)) {
                goodPairs += freqMap.get(key);
            }
            freqMap.put(key, freqMap.getOrDefault(key, 0L) + 1);
        }
        
        return totalPairs - goodPairs;
    }
}
