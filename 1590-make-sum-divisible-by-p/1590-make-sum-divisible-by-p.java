import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        // Calculate the total sum and mod by p
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int remainder = (int)(totalSum % p);
        if (remainder == 0) {
            return 0; // Already divisible by p
        }
        
        // Use a hashmap to store prefix sum mod p and its index
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1); // We initialize the modMap with mod 0 at index -1 to handle edge cases
        int minLength = nums.length;
        long prefixSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int currentMod = (int)(prefixSum % p);
            
            // We need to find if (prefixSum - remainder) mod p exists
            int targetMod = (currentMod - remainder + p) % p;
            
            if (modMap.containsKey(targetMod)) {
                minLength = Math.min(minLength, i - modMap.get(targetMod));
            }
            
            // Store the current prefix sum mod p and its index
            modMap.put(currentMod, i);
        }
        
        return minLength == nums.length ? -1 : minLength;
    }
}
