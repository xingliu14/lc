// https://leetcode.com/problems/binary-tree-preorder-traversal/
// 简单的递归

class Solution {
    List<Integer> result = new ArrayList<> ();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return result;
        }
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }
}