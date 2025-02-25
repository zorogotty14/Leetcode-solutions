class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int oddCount = 0, evenCount = 1;  // evenCount starts at 1 for the prefix sum = 0 case
        int sum = 0, result = 0;

        for (int num : arr) {
            sum += num;
            
            // Check the parity of the current prefix sum
            if (sum % 2 == 0) {
                result = (result + oddCount) % MOD; // Odd sum subarrays end here
                evenCount++;  // Update even count
            } else {
                result = (result + evenCount) % MOD; // Even sum subarrays end here
                oddCount++;  // Update odd count
            }
        }
        
        return result;
    }
}
