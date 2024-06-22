class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);  // Initializing with count 1 for the base case
        int count = 0;
        int currentOddCount = 0;

        for (int num : nums) {
            // Increase currentOddCount if the current number is odd
            if (num % 2 == 1) {
                currentOddCount++;
            }

            // Check if there exists a prefix with currentOddCount - k
            count += prefixCount.getOrDefault(currentOddCount - k, 0);

            // Update the prefixCount map with the currentOddCount
            prefixCount.put(currentOddCount, prefixCount.getOrDefault(currentOddCount, 0) + 1);
        }

        return count;
    }
}