import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // Step 1: Store sums of nums1[i] + nums2[j] and their frequencies in a hashmap
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // Step 2: Check if -(nums3[k] + nums4[l]) exists in the map
        int count = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                if (map.containsKey(target)) {
                    count += map.get(target); // Add the frequency of the complement
                }
            }
        }

        return count;
    }
}
