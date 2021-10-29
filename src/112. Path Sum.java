// https://leetcode.com/problems/path-sum/
// 就是左右反复递归，注意他可以是负数

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return root.val == sum;
        } else if(root.left == null) {
            return hasPathSum(root.right, sum - root.val);
        } else if(root.right == null) {
            return hasPathSum(root.left, sum - root.val);
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}