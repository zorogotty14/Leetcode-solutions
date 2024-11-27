class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];
        int prev = Integer.MIN_VALUE / 2; // Initialize to a very small value

        // First pass: Left to Right
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            answer[i] = i - prev;
        }

        int next = Integer.MAX_VALUE / 2; // Initialize to a very large value

        // Second pass: Right to Left
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                next = i;
            }
            answer[i] = Math.min(answer[i], next - i);
        }

        return answer;
    }
}
