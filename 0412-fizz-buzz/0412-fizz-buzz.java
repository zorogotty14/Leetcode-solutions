import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        // Initialize the result list
        List<String> result = new ArrayList<>();
        
        // Loop through numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                // Divisible by both 3 and 5
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                // Divisible by 3
                result.add("Fizz");
            } else if (i % 5 == 0) {
                // Divisible by 5
                result.add("Buzz");
            } else {
                // Neither divisible by 3 nor 5
                result.add(String.valueOf(i));
            }
        }
        
        return result;
    }
}
