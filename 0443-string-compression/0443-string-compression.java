class Solution {
    public int compress(char[] chars) {
        int read = 0;   // Pointer to read the characters
        int write = 0;  // Pointer to write the compressed characters

        while (read < chars.length) {
            char currentChar = chars[read];  // Current character to process
            int count = 0;  // Count of consecutive repeating characters

            // Count the number of times the current character repeats
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the current character to the array
            chars[write] = currentChar;
            write++;

            // If the count is greater than 1, write the count to the array
            if (count > 1) {
                // Convert count to string and write each character
                String countStr = Integer.toString(count);
                for (char c : countStr.toCharArray()) {
                    chars[write] = c;
                    write++;
                }
            }
        }

        // Return the length of the compressed array
        return write;
    }
}
