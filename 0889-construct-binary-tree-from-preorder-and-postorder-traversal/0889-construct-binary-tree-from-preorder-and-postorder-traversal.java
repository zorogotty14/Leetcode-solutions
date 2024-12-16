class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        // The root is the first element of preorder
        TreeNode root = new TreeNode(preorder[preStart]);

        // If there's only one node, return it
        if (preStart == preEnd) {
            return root;
        }

        // Find the root of the left subtree (second element in preorder)
        int leftRootVal = preorder[preStart + 1];
        int leftRootIndex = postStart;

        // Find the index of leftRootVal in postorder
        while (postorder[leftRootIndex] != leftRootVal) {
            leftRootIndex++;
        }

        // Calculate the size of the left subtree
        int leftSize = leftRootIndex - postStart + 1;

        // Recursively construct the left and right subtrees
        root.left = construct(preorder, preStart + 1, preStart + leftSize, postorder, postStart, leftRootIndex);
        root.right = construct(preorder, preStart + leftSize + 1, preEnd, postorder, leftRootIndex + 1, postEnd - 1);

        return root;
    }
}
