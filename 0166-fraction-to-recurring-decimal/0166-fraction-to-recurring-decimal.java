import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        
        // Determine the sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        
        // Convert to long to avoid overflow
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);
        
        // Integer part
        result.append(num / denom);
        long remainder = num % denom;
        if (remainder == 0) {
            return result.toString(); // No fractional part
        }
        
        // Fractional part
        result.append(".");
        Map<Long, Integer> remainderMap = new HashMap<>();
        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                // Repeating fraction detected
                result.insert(remainderMap.get(remainder), "(");
                result.append(")");
                break;
            }
            
            // Store the position where this remainder first appeared
            remainderMap.put(remainder, result.length());
            
            remainder *= 10;
            result.append(remainder / denom);
            remainder %= denom;
        }
        
        return result.toString();
    }
}
