import java.util.HashMap;
import java.util.Map;

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int n = nums.length;
        int result = 0;
        
        // Compute all pairs and store their product count
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        // Count valid tuples
        for (int count : productCount.values()) {
            if (count > 1) {
                result += (count * (count - 1) / 2) * 8;  // Choose 2 pairs from count & 8 permutations
            }
        }
        
        return result;
    }
}
