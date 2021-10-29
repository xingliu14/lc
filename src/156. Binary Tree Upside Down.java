// https://leetcode.com/problems/binary-tree-upside-down/
// 题意非常迷惑，但其实只需要反转最右边即可。用递归是从下往上，用循环是从上往下。

class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}