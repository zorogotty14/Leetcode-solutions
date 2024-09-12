class Solution {
    public int integerReplacement(int n) {
        long num = n;  // Use long to avoid overflow when n = Integer.MAX_VALUE
        int steps = 0;
        
        while (num != 1) {
            if (num % 2 == 0) {
                // If n is even, divide by 2
                num /= 2;
            } else {
                // If n is odd, we choose between incrementing or decrementing
                if (num == 3 || (num & 2) == 0) {
                    // Special case: if num is 3, subtracting is better
                    // Also, prefer subtracting if num+1 creates a multiple of 4 (checked using num & 2)
                    num--;
                } else {
                    num++;
                }
            }
            steps++;
        }
        
        return steps;
    }
}
