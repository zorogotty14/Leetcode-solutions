/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        // Base case: If the tree is empty, depth is 0
        if (root == null) return 0;

        // Initialize the max depth to 0
        int maxDepth = 0;

        // Recursively find the max depth of each child
        for (Node child : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth(child));
        }

        // Add 1 to account for the current node
        return maxDepth + 1;
    }
}