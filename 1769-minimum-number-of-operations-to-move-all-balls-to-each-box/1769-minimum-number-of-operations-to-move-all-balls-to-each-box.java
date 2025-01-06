class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        // Left-to-right pass
        int operations = 0;  // Cumulative operations from the left
        int balls = 0;       // Number of balls encountered so far
        for (int i = 0; i < n; i++) {
            answer[i] += operations;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            operations += balls;
        }

        // Right-to-left pass
        operations = 0;  // Reset cumulative operations for the right
        balls = 0;       // Reset the number of balls encountered
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += operations;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            operations += balls;
        }

        return answer;
    }
}
