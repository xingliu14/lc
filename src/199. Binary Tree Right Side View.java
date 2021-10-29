// https://leetcode.com/problems/binary-tree-right-side-view/
// level order traversal

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<> ();
        List<TreeNode> curr = new ArrayList<> ();
        if(root == null) {
            return result;
        }
        curr.add(root);
        while(curr.size() != 0) {
            int len = curr.size();
            for(int i = 0; i < len; i++) {
                TreeNode temp = curr.get(0);
                curr.remove(0);
                if(i == len - 1) {
                    result.add(temp.val);
                }
                if(temp.left != null) {
                    curr.add(temp.left);
                }
                if(temp.right != null) {
                    curr.add(temp.right);
                }
            }
        }
        return result;
    }
}