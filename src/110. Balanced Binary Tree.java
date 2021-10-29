// https://leetcode.com/problems/balanced-binary-tree/
// 通过它的定义，找每个点的左右高度

class Solution {
    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }
}