class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();  // Convert the string to a character array for in-place manipulation
        int n = arr.length;
        
        // Iterate over the string in chunks of 2k
        for (int i = 0; i < n; i += 2 * k) {
            // Find the bounds for reversing: from i to i + k (or the end of the string)
            int left = i;
            int right = Math.min(i + k - 1, n - 1);  // Ensure we don't go out of bounds
            
            // Reverse the first k characters in the current chunk
            while (left < right) {
                // Swap arr[left] and arr[right]
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        
        // Convert the character array back to a string
        return new String(arr);
    }
}
