class Solution {
    public boolean validUtf8(int[] data) {
        int remainingBytes = 0;  // Number of bytes to be checked for continuation

        for (int byteData : data) {
            // Extract the least significant 8 bits
            if (remainingBytes == 0) {
                // Determine the number of leading 1's in the first byte
                if ((byteData >> 5) == 0b110) {  // 110xxxxx => 2-byte character
                    remainingBytes = 1;
                } else if ((byteData >> 4) == 0b1110) {  // 1110xxxx => 3-byte character
                    remainingBytes = 2;
                } else if ((byteData >> 3) == 0b11110) {  // 11110xxx => 4-byte character
                    remainingBytes = 3;
                } else if ((byteData >> 7) == 0b0) {  // 0xxxxxxx => 1-byte character
                    remainingBytes = 0;
                } else {
                    return false;  // Invalid leading byte
                }
            } else {
                // Check if the byte is a valid continuation byte (10xxxxxx)
                if ((byteData >> 6) != 0b10) {
                    return false;
                }
                remainingBytes--;
            }
        }

        // If all characters are valid, remainingBytes should be 0
        return remainingBytes == 0;
    }
}
