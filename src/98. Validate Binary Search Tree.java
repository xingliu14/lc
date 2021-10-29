// https://leetcode.com/problems/validate-binary-search-tree/
// 设定一个range然后疯狂递归

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode curr, long minValue, long maxValue) {
        if(curr == null) {
            return true;
        }
        if(curr.val <= minValue || curr.val >= maxValue) {
            return false;
        }
        return helper(curr.left, minValue, curr.val) && helper(curr.right, curr.val, maxValue);
    }
}