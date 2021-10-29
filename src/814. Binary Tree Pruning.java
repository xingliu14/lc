// https://leetcode.com/problems/binary-tree-pruning/
// 递归搞起，注意最开始其实定义的是最后的basic case

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val == 1 || root.left != null || root.right != null) {
            return root;
        }
        return null;
    }
}