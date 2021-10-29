// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
// backtrack无敌

class Solution {
    int result = 0;
    
    public int goodNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        backtrack(root, root.val);
        return result;
    }
    
    private void backtrack(TreeNode root, int max) {
        if(root == null) {
            return;
        }
        if(root.val >= max) {
            result++;
            max = root.val;
        }
        backtrack(root.left, max);
        backtrack(root.right, max);
    }
}