class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // Define the modulo constant
        int MOD = 1000000007;

        // Step 1: Compute all non-empty continuous subarray sums
        ArrayList<Integer> subarraySums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums.add(sum);
            }
        }

        // Step 2: Sort the computed sums in non-decreasing order
        Collections.sort(subarraySums);

        // Step 3: Sum the elements from the 'left' index to the 'right' index
        long result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + subarraySums.get(i)) % MOD;
        }

        // Step 4: Return the result modulo 10^9 + 7
        return (int) result;
    }
}