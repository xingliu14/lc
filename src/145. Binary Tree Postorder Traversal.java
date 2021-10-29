// https://leetcode.com/problems/binary-tree-postorder-traversal/
// 我这个iterate太麻烦了，还有个更普世的简单的itarate方法请见这里：https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<> ();
        Deque<TreeNode> stack = new ArrayDeque<> ();
        Set<TreeNode> visited = new HashSet<> ();
        if(root == null) {
            return result;
        }
        stack.push(root);
        while(stack.size() != 0) {
            TreeNode curr = stack.pop();
            visited.add(curr);
            if(nullOrVisited(curr.left, visited) && nullOrVisited(curr.right, visited)) {
                result.add(curr.val);
            } else {
                stack.push(curr);
                if(!nullOrVisited(curr.right, visited)) {
                    stack.push(curr.right);
                }
                if(!nullOrVisited(curr.left, visited)) {
                    stack.push(curr.left);
                }
            }
        }
        return result;
    }
    
    private boolean nullOrVisited(TreeNode node, Set<TreeNode> set) {
        return node == null || set.contains(node);
    }
}