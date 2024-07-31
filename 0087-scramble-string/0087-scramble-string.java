class Solution {
    private int[][][] memo;

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) return false;
        memo = new int[n][n][n + 1];
        for (int[][] layer : memo) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return isScrambleHelper(s1, s2, 0, 0, n);
    }

    private boolean isScrambleHelper(String s1, String s2, int i1, int i2, int length) {
        if (memo[i1][i2][length] != -1) {
            return memo[i1][i2][length] == 1;
        }
        if (s1.substring(i1, i1 + length).equals(s2.substring(i2, i2 + length))) {
            memo[i1][i2][length] = 1;
            return true;
        }

        if (!isAnagram(s1, s2, i1, i2, length)) {
            memo[i1][i2][length] = 0;
            return false;
        }

        for (int split = 1; split < length; split++) {
            if (isScrambleHelper(s1, s2, i1, i2, split) && isScrambleHelper(s1, s2, i1 + split, i2 + split, length - split) ||
                isScrambleHelper(s1, s2, i1, i2 + length - split, split) && isScrambleHelper(s1, s2, i1 + split, i2, length - split)) {
                memo[i1][i2][length] = 1;
                return true;
            }
        }
        memo[i1][i2][length] = 0;
        return false;
    }

    private boolean isAnagram(String s1, String s2, int i1, int i2, int length) {
        int[] count = new int[26];
        for (int i = 0; i < length; i++) {
            count[s1.charAt(i1 + i) - 'a']++;
            count[s2.charAt(i2 + i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}