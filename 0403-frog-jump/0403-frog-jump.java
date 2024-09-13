import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        // If the second stone is not exactly 1 unit away, the frog can't make the first jump
        if (stones[1] != 1) return false;
        
        // Map where each stone is associated with a set of possible jump lengths
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        
        // Initialize the map with an empty set for each stone
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        
        // The frog starts at the first stone and can only jump 1 unit from the first stone
        dp.get(0).add(1);
        
        // Process each stone and its reachable jumps
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            Set<Integer> jumps = dp.get(stone);
            
            // Iterate over each jump that can reach the current stone
            for (int jump : jumps) {
                int reach = stone + jump;
                
                // If the next stone exists, update its possible jumps
                if (dp.containsKey(reach)) {
                    // Add the possible jumps from the reached stone: jump-1, jump, and jump+1
                    if (jump - 1 > 0) dp.get(reach).add(jump - 1);
                    dp.get(reach).add(jump);
                    dp.get(reach).add(jump + 1);
                }
            }
        }
        
        // If the last stone has any possible jumps, the frog can reach it
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}
