class Solution {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        return superPowHelper(a, b, b.length - 1);
    }

    private int superPowHelper(int a, int[] b, int idx) {
        if (idx == -1) {
            return 1;
        }

        // Break down the power
        int lastDigit = b[idx];
        int part1 = modPow(a, lastDigit); // a^lastDigit % MOD
        int part2 = modPow(superPowHelper(a, b, idx - 1), 10); // (previous result)^10 % MOD
        
        // Combine both parts using modular multiplication
        return (part1 * part2) % MOD;
    }

    // Function to perform modular exponentiation
    private int modPow(int x, int n) {
        x %= MOD;
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = (result * x) % MOD;
        }
        return result;
    }
}
