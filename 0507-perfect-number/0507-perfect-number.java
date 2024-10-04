class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false; // No perfect number is <= 1
        }
        
        int sum = 1; // Start with 1 as it is a divisor for all numbers
        
        // Iterate from 2 to sqrt(num)
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) { // If i is a divisor
                sum += i;
                
                // Add the corresponding divisor (num / i), but avoid adding num itself
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        
        // After summing divisors, check if sum equals num
        return sum == num;
    }
}
