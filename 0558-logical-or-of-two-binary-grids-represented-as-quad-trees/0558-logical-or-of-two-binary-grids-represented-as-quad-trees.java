/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        // Case 1: If one of the trees is a leaf
        if (quadTree1.isLeaf) {
            // If quadTree1 is a leaf and its value is true (1), return quadTree1
            if (quadTree1.val) return new Node(true, true, null, null, null, null);
            // Otherwise, return quadTree2 as it holds the useful data
            return quadTree2;
        }
        if (quadTree2.isLeaf) {
            // If quadTree2 is a leaf and its value is true (1), return quadTree2
            if (quadTree2.val) return new Node(true, true, null, null, null, null);
            // Otherwise, return quadTree1 as it holds the useful data
            return quadTree1;
        }

        // Case 2: Both nodes are internal nodes, so we need to recurse on each child
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        // If all four children are leaves and have the same value, merge them into a single leaf
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }

        // Otherwise, return a new internal node with the four children
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}