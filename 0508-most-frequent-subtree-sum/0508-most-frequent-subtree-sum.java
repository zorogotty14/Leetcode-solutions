import java.util.*;

class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        // Map to store the frequency of each subtree sum
        Map<Integer, Integer> sumFrequencyMap = new HashMap<>();
        // Helper function to compute the subtree sums
        computeSubtreeSums(root, sumFrequencyMap);
        
        // Find the maximum frequency of any sum
        int maxFrequency = 0;
        for (int freq : sumFrequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, freq);
        }
        
        // Collect all sums that have the maximum frequency
        List<Integer> mostFrequentSums = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumFrequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                mostFrequentSums.add(entry.getKey());
            }
        }
        
        // Convert the list to an array
        int[] result = new int[mostFrequentSums.size()];
        for (int i = 0; i < mostFrequentSums.size(); i++) {
            result[i] = mostFrequentSums.get(i);
        }
        
        return result;
    }

    // Helper function to compute subtree sums in post-order traversal
    private int computeSubtreeSums(TreeNode node, Map<Integer, Integer> sumFrequencyMap) {
        if (node == null) {
            return 0;
        }
        
        // Post-order: first calculate the sums of the left and right subtrees
        int leftSum = computeSubtreeSums(node.left, sumFrequencyMap);
        int rightSum = computeSubtreeSums(node.right, sumFrequencyMap);
        
        // The sum of the current subtree is the sum of the left, right, and the node's value
        int subtreeSum = leftSum + rightSum + node.val;
        
        // Update the frequency of this sum in the map
        sumFrequencyMap.put(subtreeSum, sumFrequencyMap.getOrDefault(subtreeSum, 0) + 1);
        
        // Return the current subtree sum to the parent node
        return subtreeSum;
    }
}
