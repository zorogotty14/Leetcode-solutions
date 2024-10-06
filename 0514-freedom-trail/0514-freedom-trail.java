import java.util.*;

class Solution {
    public int findRotateSteps(String ring, String key) {
        // Map to store the indices of each character in the ring
        Map<Character, List<Integer>> charToIndex = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            charToIndex.computeIfAbsent(ring.charAt(i), x -> new ArrayList<>()).add(i);
        }

        // DP memoization table
        int[][] memo = new int[ring.length()][key.length()];

        // Initialize memoization table with -1
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Start the recursive function from the 0th position of the ring and the 0th character of the key
        return findSteps(ring, key, 0, 0, charToIndex, memo);
    }

    private int findSteps(String ring, String key, int ringPos, int keyPos, Map<Character, List<Integer>> charToIndex, int[][] memo) {
        // If we have processed the entire key, return 0
        if (keyPos == key.length()) {
            return 0;
        }

        // Check if the result is already memoized
        if (memo[ringPos][keyPos] != -1) {
            return memo[ringPos][keyPos];
        }

        // Get the list of positions in the ring for the current key character
        char currentChar = key.charAt(keyPos);
        List<Integer> targetPositions = charToIndex.get(currentChar);

        int n = ring.length();
        int minSteps = Integer.MAX_VALUE;

        // Try all positions where the current character is located in the ring
        for (int targetPos : targetPositions) {
            // Calculate the distance clockwise and anticlockwise
            int clockwiseDistance = Math.abs(targetPos - ringPos);
            int anticlockwiseDistance = n - clockwiseDistance;

            // Choose the minimum of the two distances
            int stepsToAlign = Math.min(clockwiseDistance, anticlockwiseDistance);

            // Recursively compute the steps for the rest of the key
            int totalSteps = stepsToAlign + findSteps(ring, key, targetPos, keyPos + 1, charToIndex, memo);
            
            // Include one step for pressing the button
            minSteps = Math.min(minSteps, totalSteps + 1);
        }

        // Memoize the result
        memo[ringPos][keyPos] = minSteps;
        return minSteps;
    }
}

