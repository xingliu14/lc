// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// 这个tree的题没有用递归，但是需要考虑怎么divide and conqure，主要是想他的处理顺序，左子树一定优先于右子树，于是对于每个点只需要把左子树照搬到右边，然后嫁接右子树，一直到最后即可。

class Solution {
    public void flatten(TreeNode root) {
        while(root != null) {
            moveLeftToRight(root);
            root = root.right;
        }
    }
    
    private void moveLeftToRight(TreeNode curr) {
        if(curr == null) {
            return;
        }
        if(curr.left != null) {
            TreeNode originalRight = curr.right;
            curr.right = curr.left;
            curr.left = null;
            if(originalRight != null) {
                while(curr.right != null) {
                    curr = curr.right;
                }
                curr.right = originalRight;
            }
        }
    }
}