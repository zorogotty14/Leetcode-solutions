class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // Base case for n = 0
        if (n == 0) {
            return 1;
        }
        
        // Start with n = 1 case, which is 10 unique numbers (0 through 9)
        int totalUniqueNumbers = 10;
        int uniqueDigits = 9;  // The first digit can't be 0
        int availableDigits = 9;  // 9 digits left to choose from
        
        // For n = 2 to n (inclusive)
        for (int i = 2; i <= n && availableDigits > 0; i++) {
            uniqueDigits *= availableDigits;
            totalUniqueNumbers += uniqueDigits;
            availableDigits--;  // Reduce the number of available digits for each step
        }
        
        return totalUniqueNumbers;
    }
}
