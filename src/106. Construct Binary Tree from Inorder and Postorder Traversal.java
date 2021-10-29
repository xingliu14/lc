// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// 和preorder差不多，只不过只从后往前找

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length - 1;
        return helper(0, len, len, inorder, postorder);
    }
    
    private TreeNode helper(int inStart, int inEnd, int postEnd, int[] inorder, int[] postorder) {
        if(inStart > inEnd || postEnd < 0) {
            return null;
        }
        TreeNode curr = new TreeNode(postorder[postEnd]);
        int inIndex = -1;
        for(int i = inEnd; i >= inStart; i--) {
            if(inorder[i] == postorder[postEnd]) {
                inIndex = i;
                break;
            }
        }
        curr.left = helper(inStart, inIndex - 1, postEnd - inEnd + inIndex - 1, inorder, postorder);
        curr.right = helper(inIndex + 1, inEnd, postEnd - 1, inorder, postorder);
        return curr;
    }
}