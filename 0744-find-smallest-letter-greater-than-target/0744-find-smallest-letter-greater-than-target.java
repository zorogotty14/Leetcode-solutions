class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        
        // Binary search to find the smallest character greater than target
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] > target) {
                high = mid - 1; // Continue searching in the left half
            } else {
                low = mid + 1; // Continue searching in the right half
            }
        }
        
        // If we exit the loop and didn't find a character greater than target,
        // we return letters[low % letters.length] to wrap around to the first element
        return letters[low % letters.length];
    }
}
