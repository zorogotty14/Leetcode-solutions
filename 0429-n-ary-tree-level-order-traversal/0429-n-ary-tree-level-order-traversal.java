import java.util.*;

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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result; // Return empty list if the tree is empty
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll(); // Dequeue the next node
                currentLevel.add(node.val);

                // Enqueue all the children of the current node
                for (Node child : node.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }

            result.add(currentLevel); // Add current level to the result
        }

        return result;
    }
}
