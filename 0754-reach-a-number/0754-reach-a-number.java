class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target); // Consider the positive equivalent of target
        int sum = 0;
        int steps = 0;

        // Keep moving until the sum reaches or surpasses the target
        while (sum < target || (sum - target) % 2 != 0) {
            steps++;
            sum += steps;
        }

        return steps;
    }
}
