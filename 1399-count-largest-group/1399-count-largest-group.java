class Solution {
    public int countLargestGroup(int n) {
        // Map to store the count of numbers with the same digit sum
        int[] digitSumCount = new int[37]; // Maximum possible digit sum for n <= 10^4 is 9+9+9+9=36
        
        // Calculate digit sum for each number and update the count
        for (int i = 1; i <= n; i++) {
            int digitSum = getDigitSum(i);
            digitSumCount[digitSum]++;
        }
        
        // Find the maximum group size
        int maxSize = 0;
        for (int count : digitSumCount) {
            maxSize = Math.max(maxSize, count);
        }
        
        // Count how many groups have the maximum size
        int result = 0;
        for (int count : digitSumCount) {
            if (count == maxSize) {
                result++;
            }
        }
        
        return result;
    }
    
    // Helper method to calculate the sum of digits of a number
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}