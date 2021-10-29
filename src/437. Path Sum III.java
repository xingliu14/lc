// https://leetcode.com/problems/path-sum-iii/
// 直接暴力怼起，两个递归

class Solution {
    int result = 0, target = 0;
    
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        findPathFromRoot(root);
        return result;
    }
    
    private void findPathFromRoot(TreeNode root) {
        if(null == root) {
            return;
        }
        findPath(root, 0);
        findPathFromRoot(root.left);
        findPathFromRoot(root.right);
    }
    
    private void findPath(TreeNode node, int curr) {
        if(null == node) {
            return;
        }
        if(curr + node.val == target) {
            result++;
        }
        findPath(node.left, curr + node.val);
        findPath(node.right, curr + node.val);
    }
}