// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// 使用dp找出第一个node的倒序路径，然后正好倒序来找第二个node

class Solution {
    
    List<TreeNode> list;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        list = new ArrayList<> ();
        findNode(root, p);
        for(TreeNode node : list) {
            if(findNode(node, q)) {
                return node;
            }
        }
        return root;
    }
    
    private boolean findNode(TreeNode root, TreeNode target) {
        if(root == null) {
            return false;
        }
        if(root.val == target.val || findNode(root.left, target) || findNode(root.right, target)) {
            list.add(root);
            return true;
        }
        return false;
    }
}