import java.util.HashSet;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        HashSet<Integer> seenA = new HashSet<>();
        HashSet<Integer> seenB = new HashSet<>();
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            // Add current elements of A and B to their respective sets
            if (seenB.contains(A[i])) {
                commonCount++;
            }
            seenA.add(A[i]);

            if (seenA.contains(B[i])) {
                commonCount++;
            }
            seenB.add(B[i]);

            // Store the count of common elements
            result[i] = commonCount;
        }

        return result;
    }
}
