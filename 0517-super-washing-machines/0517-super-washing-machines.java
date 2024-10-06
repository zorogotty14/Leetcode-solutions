class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int totalDresses = 0;
        
        // Calculate total number of dresses
        for (int dresses : machines) {
            totalDresses += dresses;
        }
        
        // Check if the dresses can be evenly distributed
        if (totalDresses % n != 0) {
            return -1;
        }
        
        int target = totalDresses / n; // Each machine should have this many dresses
        int maxMoves = 0;              // The minimum number of moves required
        int cumulativeImbalance = 0;   // Running imbalance between machines
        
        // Iterate over each machine
        for (int dresses : machines) {
            // Calculate the local imbalance of the current machine
            int imbalance = dresses - target;
            cumulativeImbalance += imbalance;
            
            // The result is the maximum between the local imbalance or cumulative imbalance
            maxMoves = Math.max(maxMoves, Math.max(Math.abs(cumulativeImbalance), imbalance));
        }
        
        return maxMoves;
    }
}
