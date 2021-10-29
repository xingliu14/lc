// https://leetcode.com/problems/recover-binary-search-tree/
// in order traverse就可以找到大小不对的node，但是怎么保存node呢，就要靠class的Node，这样在不同的递归过程也能共享数据。特别注意当我们找到一个数据不对的位置之后，需要更新两个node，因为有可能就是相邻的两个node交换，但之后再有符合大小关系的就要更新。

class Solution {
    TreeNode first, second, prev;
    
    public void recoverTree(TreeNode root) {
        traverse(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return;
    }
    
    private void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        
        traverse(root.left);
        
        if(prev != null && prev.val > root.val) {
            if(first == null) {
                first = prev;
            } 
            second = root;
        }
        prev = root;
        
        traverse(root.right);
    }
}