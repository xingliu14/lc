// https://leetcode.com/problems/binary-tree-inorder-traversal/
// while条件需要有两个。传送门，全部的循环tarversal方法：https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<> ();
        Deque<TreeNode> stack = new LinkedList<> ();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}