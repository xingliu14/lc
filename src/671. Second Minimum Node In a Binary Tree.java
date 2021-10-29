// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
// 不能用bfs因为在任何一层都有可能出现第二小的，必须全部遍历

class Solution {
    int min = 0;
    long second = Long.MAX_VALUE;
    
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);
        return second == Long.MAX_VALUE ? -1 : (int) second;
    }
    
    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        if(node.val != min) {
            second = Math.min(second, node.val);
        }
        dfs(node.left);
        dfs(node.right);
    }
}