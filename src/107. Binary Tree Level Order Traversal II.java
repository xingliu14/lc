// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
// 就和正常的一样，不过加入list的时候，加到第一个

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<> ();
        if(root == null) {
            return result;
        }
        List<TreeNode> curr = new ArrayList<> ();
        curr.add(root);
        while(!curr.isEmpty()) {
            List<Integer> currRow = new ArrayList<> ();
            int len = curr.size();
            for(int i = 0; i < len; i++) {
                TreeNode currNode = curr.get(0);
                currRow.add(currNode.val);
                if(currNode.left != null) {
                    curr.add(currNode.left);
                }
                if(currNode.right != null) {
                    curr.add(currNode.right);
                }
                curr.remove(0);
            }
            result.add(0, currRow);
        }
        return result;
    }
}