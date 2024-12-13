class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        final int MOD = 1_000_000_007;

        // Calculate the Least Common Multiple (LCM) of a and b
        long lcm = (long) a * b / gcd(a, b);

        long left = 1, right = (long) n * Math.min(a, b);
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid / a + mid / b - mid / lcm < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int) (left % MOD);
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}