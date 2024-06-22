class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);  // Initialize to handle the case when subarray starts from index 0
        int count = 0;
        int currentOddCount = 0;

        for (int num : nums) {
            // Increase currentOddCount if the current number is odd
            if (num % 2 == 1) {
                currentOddCount++;
            }

            // If currentOddCount - k exists in the prefixCount map, it means there are some subarrays
            // ending at the current index which have exactly k odd numbers.
            if (prefixCount.containsKey(currentOddCount - k)) {
                count += prefixCount.get(currentOddCount - k);
            }

            // Update the prefixCount map with the currentOddCount
            prefixCount.put(currentOddCount, prefixCount.getOrDefault(currentOddCount, 0) + 1);
        }

        return count;
    }
}