import java.util.*;

class Solution {
    public String originalDigits(String s) {
        // Frequency count of each letter in the input string
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // Array to store the count of each digit (0-9)
        int[] digits = new int[10];
        
        // Identifying digits by unique characters
        digits[0] = count['z' - 'a']; // "zero"
        digits[2] = count['w' - 'a']; // "two"
        digits[4] = count['u' - 'a']; // "four"
        digits[6] = count['x' - 'a']; // "six"
        digits[8] = count['g' - 'a']; // "eight"
        
        // Identifying remaining digits
        digits[3] = count['h' - 'a'] - digits[8]; // "three" (after removing "eight")
        digits[5] = count['f' - 'a'] - digits[4]; // "five" (after removing "four")
        digits[7] = count['s' - 'a'] - digits[6]; // "seven" (after removing "six")
        digits[1] = count['o' - 'a'] - digits[0] - digits[2] - digits[4]; // "one" (after removing "zero", "two", and "four")
        digits[9] = count['i' - 'a'] - digits[5] - digits[6] - digits[8]; // "nine" (after removing "five", "six", and "eight")
        
        // Construct the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < digits[i]; j++) {
                result.append(i);
            }
        }
        
        return result.toString();
    }
}
