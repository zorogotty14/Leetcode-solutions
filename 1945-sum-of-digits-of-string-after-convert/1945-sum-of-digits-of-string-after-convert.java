class Solution {
    public int getLucky(String s, int k) {
        // Step 1: Convert the string to a number string
        StringBuilder numStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            int value = c - 'a' + 1;
            numStr.append(value);
        }

        // Step 2: Transform the number k times
        String num = numStr.toString();
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char digit : num.toCharArray()) {
                sum += digit - '0';
            }
            num = String.valueOf(sum);
        }

        // Return the final result
        return Integer.parseInt(num);
    }
}
