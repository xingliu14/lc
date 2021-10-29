// https://leetcode.com/problems/diameter-of-binary-tree/submissions/
// 就是一个递归干两件事

class Solution {
    int max = 0;
    Map<TreeNode, Integer> map = new HashMap<> ();
        
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    
    private int depth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftDepth = depth(node.left), rightDepth = depth(node.right);
        max = Math.max(max, leftDepth + rightDepth);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}