class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0"; // Base case
        }
        
        boolean isNegative = num < 0; // Check if number is negative
        num = Math.abs(num); // Work with the absolute value of the number
        
        StringBuilder result = new StringBuilder();
        
        // Convert to base 7
        while (num > 0) {
            result.append(num % 7); // Append remainder (next digit in base 7)
            num /= 7; // Reduce the number by dividing by 7
        }
        
        if (isNegative) {
            result.append("-"); // Prepend '-' for negative numbers
        }
        
        return result.reverse().toString(); // Reverse to get the correct order
    }
}
