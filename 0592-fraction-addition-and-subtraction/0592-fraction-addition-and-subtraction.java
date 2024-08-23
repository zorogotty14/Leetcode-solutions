import java.util.*;

class Solution {
    public String fractionAddition(String expression) {
        // Initialize numerator and denominator for the final result
        int numerator = 0, denominator = 1;
        
        // Use a scanner to parse the string
        Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
        
        while (sc.hasNext()) {
            int num = sc.nextInt(); // Read numerator
            int denom = sc.nextInt(); // Read denominator
            
            // Calculate the new numerator by adding the fractions
            numerator = numerator * denom + num * denominator;
            // Update the denominator (common denominator)
            denominator *= denom;
            
            // Simplify the fraction by finding the greatest common divisor (GCD)
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return numerator + "/" + denominator;
    }
    
    // Function to compute GCD (Greatest Common Divisor) using Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
