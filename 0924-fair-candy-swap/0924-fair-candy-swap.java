import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        // Calculate the total candies for Alice and Bob
        int sumAlice = 0, sumBob = 0;
        for (int size : aliceSizes) {
            sumAlice += size;
        }
        for (int size : bobSizes) {
            sumBob += size;
        }

        // Calculate the target difference
        int delta = (sumBob - sumAlice) / 2;

        // Use a set to store Bob's candy sizes
        Set<Integer> bobSet = new HashSet<>();
        for (int size : bobSizes) {
            bobSet.add(size);
        }

        // Find the pair (x, y) that satisfies the condition
        for (int x : aliceSizes) {
            int y = x + delta;
            if (bobSet.contains(y)) {
                return new int[]{x, y};
            }
        }

        // Return an empty array if no solution is found (this won't happen as per constraints)
        return new int[]{};
    }
}
