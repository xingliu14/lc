// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// 使用inorder，每次保证经过自己的时候减1。如果已经为0了，就直接返回。

class Solution {
    int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        return inorder(root);
    }
    
    private int inorder(TreeNode node) {
        if(node == null) {
            return -1;
        }
        int left = inorder(node.left);
        if(count == 0) {
            return left;
        }
        count--;
        if(count == 0) {
            return node.val;
        }
        return inorder(node.right);
    }
}