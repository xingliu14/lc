// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// 不能简单的反过来遍历，因为插入下一排也会受到影响，直接正着遍历一遍在reverse

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<> ();
        if(root == null) {
            return result;
        }
        List<TreeNode> list = new ArrayList<> ();
        list.add(root);
        Boolean reverse = false;
        while(!list.isEmpty()) {
            int len = list.size();
            List<Integer> currRow = new ArrayList<> ();
            for(int i = 0; i < len; i++) {
                TreeNode currNode = list.get(0);
                currRow.add(currNode.val);
                if(currNode.left != null) {
                    list.add(currNode.left);
                }
                if(currNode.right != null) {
                    list.add(currNode.right);
                }
                list.remove(0);
            }
            if(reverse) {
                Collections.reverse(currRow);
            }
            result.add(currRow);
            reverse = !reverse;
        }
        return result;
    }
}