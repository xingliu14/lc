// https://leetcode.com/problems/binary-tree-level-order-traversal/
// 用一个list，然后记录每一行本来有的个数，来一直循环下去，直到没有下一行了

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<> ();
        if(root == null) {
            return result;
        }
        List<TreeNode> nodeList = new ArrayList<> ();
        nodeList.add(root);
        while(!nodeList.isEmpty()) {
            int len = nodeList.size();
            List<Integer> currRow = new ArrayList<> ();
            for(int i = 0; i < len; i++) {
                TreeNode curr = nodeList.get(0);
                nodeList.remove(0);
                currRow.add(curr.val);
                if(curr.left != null) {
                    nodeList.add(curr.left);
                }
                if(curr.right != null) {
                    nodeList.add(curr.right);
                }
            }
            result.add(currRow);
        }
        return result;
    }
}