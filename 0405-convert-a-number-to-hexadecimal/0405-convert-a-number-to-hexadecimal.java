class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        
        // Map for hexadecimal digits
        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder hex = new StringBuilder();
        
        // We need to loop up to 8 times because we're dealing with 32-bit integers
        while (num != 0 && hex.length() < 8) {
            // Get the last 4 bits and convert it to a hex character
            hex.append(hexChars[num & 0xF]);
            // Unsigned right shift by 4 bits to process the next 4 bits
            num >>>= 4;
        }
        
        // The digits are added in reverse order, so we need to reverse the string
        return hex.reverse().toString();
    }
}
