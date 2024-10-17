class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int len = digits.length;

        // Step 1: Find the first decreasing element from the right
        int i = len - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such element is found, return -1 (already the largest permutation)
        if (i < 0) {
            return -1;
        }

        // Step 2: Find the smallest element larger than digits[i] to its right
        int j = len - 1;
        while (j > i && digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap digits[i] with digits[j]
        swap(digits, i, j);

        // Step 4: Reverse the elements to the right of i
        reverse(digits, i + 1, len - 1);

        // Convert the result back to a number
        long result = Long.parseLong(new String(digits));

        // Check if the result fits in a 32-bit integer
        return (result > Integer.MAX_VALUE) ? -1 : (int) result;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}
