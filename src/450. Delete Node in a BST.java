// https://leetcode.com/problems/delete-node-in-a-bst/
// 注意还是需要从parent来处理，所以找的时候一起处理了！

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if(root.val == key) {
            return removeRoot(root);
        }
        findNode(root, key);
        return root;
    }
    
    private boolean findNode(TreeNode root, int key) {
        if(root == null) {
            return false;
        }
        if(root.val > key) {
            if(findNode(root.left, key)) {
                root.left = removeRoot(root.left);
            }
            return false;
        } else if(root.val == key) {
            return true;
        } else {
            if(findNode(root.right, key)) {
                root.right = removeRoot(root.right);
            }
            return false;
        }
    }
    
    private TreeNode removeRoot(TreeNode root) {
        if(root.left == null) {
            return root.right;
        }
        if(root.right == null) {
            return root.left;
        }
        
        TreeNode curr = root.left;
        while(curr.right != null) {
            curr = curr.right;
        }
        curr.right = root.right;
        return root.left;
    }
}