class Solution {
    public int differenceOfSums(int n, int m) {
        // Calculate the total sum of all numbers from 1 to n
        int totalSum = n * (n + 1) / 2;
        
        // Calculate the sum of numbers divisible by m in range [1, n]
        // These are: m, 2m, 3m, ..., km where k = n/m
        int k = n / m; // Number of multiples of m in range [1, n]
        int num2 = m * k * (k + 1) / 2; // Sum of arithmetic sequence: m + 2m + 3m + ... + km
        
        // Calculate the sum of numbers not divisible by m
        int num1 = totalSum - num2;
        
        // Return the difference
        return num1 - num2;
    }
}