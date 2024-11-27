import java.util.*;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        final int MOD = 1_000_000_007;

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Create a HashMap to store the count of trees for each element
        Map<Integer, Long> dp = new HashMap<>();

        // Step 3: Populate the dp map
        for (int i = 0; i < arr.length; i++) {
            long count = 1; // Each element can at least form a tree by itself
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) { // Check if arr[j] is a factor
                    int right = arr[i] / arr[j];
                    if (dp.containsKey(right)) {
                        count = (count + dp.get(arr[j]) * dp.get(right)) % MOD;
                    }
                }
            }
            dp.put(arr[i], count);
        }

        // Step 4: Sum up all values in the dp map
        long result = 0;
        for (long value : dp.values()) {
            result = (result + value) % MOD;
        }

        return (int) result;
    }
}
