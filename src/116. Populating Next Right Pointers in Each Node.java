// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
// 这道题的关键是想明白哪些node需要被连接起来，事实上在每一层，你只需要把左右两个子树之间需要被连的连起来即可，因为这是他们之间唯一能被联系起来的地方

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        Node left = root.left, right = root.right;
        while(left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}