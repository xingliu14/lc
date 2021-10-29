// https://leetcode.com/problems/house-robber-iii/
// 这道题看到树可以用递归，看到求最值可以用dp。但本质是一样的，还是递归好写，dp很难写。

class Solution {
    public int rob(TreeNode root) {
        int[] rob = helper(root);
        return Math.max(rob[0], rob[1]);
    }
    
    private int[] helper(TreeNode root) {
        if(root == null) {
            return new int[] {0, 0};
        }
        int[] left = helper(root.left), right = helper(root.right);
        int rob = root.val + left[1] + right[1];
        int not_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {rob, not_rob};
    }
}