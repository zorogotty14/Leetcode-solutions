/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;
        
        // We will do a BFS to get values level by level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int totalSwaps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            // Collect all node values in the current level
            List<Integer> levelValues = new ArrayList<>();
            // We'll store children to process the next level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            // Calculate how many swaps needed to sort levelValues
            totalSwaps += minSwapsToSort(levelValues);
        }
        
        return totalSwaps;
    }
    
    // Returns the minimum number of swaps to sort an array "vals"
    // in strictly ascending order.
    // (Given the problem statement, we only need ascending order,
    // the "strictly" part is guaranteed because tree values are unique.)
    private int minSwapsToSort(List<Integer> vals) {
        int n = vals.size();
        // Pair each value with its index
        // e.g. pairs[i] = (vals[i], i)
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = vals.get(i);  // value
            pairs[i][1] = i;           // original index
        }
        
        // Sort the array by value
        Arrays.sort(pairs, (a,b) -> Integer.compare(a[0], b[0]));
        
        // visited array to keep track of which elements have already been placed or seen
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        // For each element in pairs
        for (int i = 0; i < n; i++) {
            // If the element is already visited or it's already in the right position, skip
            if (visited[i] || pairs[i][1] == i) {
                continue;
            }
            
            // Find the size of the cycle
            int cycleSize = 0;
            int j = i; 
            while (!visited[j]) {
                visited[j] = true;           // Mark as visited
                j = pairs[j][1];            // Move to the index where this element should go
                cycleSize++;
            }
            
            // If cycleSize = L, number of swaps needed is L - 1
            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }
        
        return swaps;
    }
}
