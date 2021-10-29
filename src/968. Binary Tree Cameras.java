// https://leetcode.com/problems/binary-tree-cameras/
// 这道题很有意思，设置三个状态，优先处理最重要的状态（贪心）。并且树全部都是bottom up处理起来最清晰

class Solution {
    private int count;
    
    public int minCameraCover(TreeNode root) {
        count = 0;
        if(dfs(root) == 0) {
            count++;
        }
        return count;
    }
    
    // 0: not-covered, 1: camera, 2: covered
    private int dfs(TreeNode node) {
        if(node == null) {
            return 2;
        }
        int left = dfs(node.left), right = dfs(node.right);
        if(left == 0 || right == 0) {
            count++;
            return 1;
        }
        if(left == 1 || right == 1) {
            return 2;
        }
        return 0;
    }
}