class Solution {
    public int mirrorReflection(int p, int q) {
        // Find the least common multiple (LCM) of p and q
        int lcm = lcm(p, q);

        // Determine the number of horizontal and vertical reflections
        int horizontalReflections = lcm / p;
        int verticalReflections = lcm / q;

        // Analyze which receptor is hit
        if (horizontalReflections % 2 == 0) {
            return 0; // East wall, receptor 0
        } else if (verticalReflections % 2 == 0) {
            return 2; // Top wall, receptor 2
        } else {
            return 1; // North wall, receptor 1
        }
    }

    // Helper function to calculate the greatest common divisor (GCD)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Helper function to calculate the least common multiple (LCM)
    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
