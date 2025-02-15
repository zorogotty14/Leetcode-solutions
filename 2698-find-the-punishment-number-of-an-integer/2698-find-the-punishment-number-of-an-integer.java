class Solution {
    public int punishmentNumber(int n) {
        int punishmentSum = 0;

        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (canPartition(Integer.toString(square), i)) {
                punishmentSum += square;
            }
        }

        return punishmentSum;
    }

    // Helper method to check if the square can be partitioned into contiguous substrings that sum to target
    private boolean canPartition(String numStr, int target) {
        return backtrack(numStr, 0, target, 0);
    }

    // Backtracking method
    private boolean backtrack(String numStr, int index, int target, int currentSum) {
        if (index == numStr.length()) {
            return currentSum == target;
        }

        int sum = 0;
        for (int i = index; i < numStr.length(); i++) {
            sum = sum * 10 + (numStr.charAt(i) - '0');
            if (backtrack(numStr, i + 1, target, currentSum + sum)) {
                return true;
            }
        }

        return false;
    }
}
