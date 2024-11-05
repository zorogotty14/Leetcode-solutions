import java.util.*;

class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        
        // Convert stickers to frequency arrays
        int[][] stickerCounts = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerCounts[i][c - 'a']++;
            }
        }
        
        // Memoization map
        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);
        
        // Start DFS to calculate minimum stickers
        return dfs(memo, stickerCounts, target);
    }
    
    private int dfs(Map<String, Integer> memo, int[][] stickerCounts, String target) {
        // Check if the result is already computed
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        
        // Convert target to a frequency array
        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }
        
        int result = Integer.MAX_VALUE;
        
        // Try each sticker to reduce the target count
        for (int[] sticker : stickerCounts) {
            // If the sticker doesn't contain the first character of the target, skip it
            if (sticker[target.charAt(0) - 'a'] == 0) {
                continue;
            }
            
            // Create a new target after using this sticker
            StringBuilder newTarget = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (targetCount[i] > 0) {
                    int remaining = targetCount[i] - sticker[i];
                    for (int j = 0; j < Math.max(0, remaining); j++) {
                        newTarget.append((char) ('a' + i));
                    }
                }
            }
            
            // Recur with the new target and calculate minimum stickers
            int temp = dfs(memo, stickerCounts, newTarget.toString());
            if (temp != -1) {
                result = Math.min(result, 1 + temp);
            }
        }
        
        // Update memoization map
        memo.put(target, result == Integer.MAX_VALUE ? -1 : result);
        return memo.get(target);
    }
}
