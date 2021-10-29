// https://leetcode.com/problems/invert-binary-tree/
// 强大的我都不屑于用递归，直接循环搞定。

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        List<TreeNode> list = new LinkedList<> ();
        list.add(root);
        while(!list.isEmpty()) {
            List<TreeNode> tempList = new LinkedList<> ();
            for(TreeNode node : list) {
                TreeNode tempNode = node.left;
                node.left = node.right;
                node.right = tempNode;
                if(node.left != null) {
                    tempList.add(node.left);
                }
                if(node.right != null) {
                    tempList.add(node.right);
                }
            }
            list = tempList;
        }
        return root;
    }
}