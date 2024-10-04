import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        
        // Create an array of pairs (score, index) and sort by score in descending order
        int[][] scoreWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            scoreWithIndex[i][0] = score[i];
            scoreWithIndex[i][1] = i;
        }
        
        // Sort the scoreWithIndex array by score in descending order
        Arrays.sort(scoreWithIndex, (a, b) -> b[0] - a[0]);
        
        // Assign ranks based on sorted order
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[scoreWithIndex[i][1]] = "Gold Medal";
            } else if (i == 1) {
                result[scoreWithIndex[i][1]] = "Silver Medal";
            } else if (i == 2) {
                result[scoreWithIndex[i][1]] = "Bronze Medal";
            } else {
                result[scoreWithIndex[i][1]] = String.valueOf(i + 1);
            }
        }
        
        return result;
    }
}
