class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        // If the target is greater than the sum of both jug capacities, return false
        if (target > x + y) {
            return false;
        }

        // If target is 0, we can always measure 0 liters
        if (target == 0) {
            return true;
        }

        // Use gcd to check if the target is achievable
        return target % gcd(x, y) == 0;
    }

    // Helper function to compute the greatest common divisor (gcd) of two numbers
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
