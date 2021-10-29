// https://leetcode.com/problems/sum-root-to-leaf-numbers/
// 使用dfs，注意每次进入下一层后都要清理StringBuilder

class Solution {
    public int result;
    
    public int sumNumbers(TreeNode root) {
        result = 0;
        if(root == null) {
            return result;
        }
        helper(root, new StringBuilder ());
        return result;
    }
    
    private void helper(TreeNode root, StringBuilder sb) {
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            result += Integer.valueOf(sb.toString());
            return;
        }
        if(root.left != null) {
            helper(root.left, sb);
            sb.setLength(sb.length() - 1);
        }
        if(root.right != null) {
            helper(root.right, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}