/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int x, int y, int length) {
        if (length == 1) {
            return new Node(grid[x][y] == 1, true);
        }

        int halfLength = length / 2;
        Node topLeft = construct(grid, x, y, halfLength);
        Node topRight = construct(grid, x, y + halfLength, halfLength);
        Node bottomLeft = construct(grid, x + halfLength, y, halfLength);
        Node bottomRight = construct(grid, x + halfLength, y + halfLength, halfLength);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        } else {
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}