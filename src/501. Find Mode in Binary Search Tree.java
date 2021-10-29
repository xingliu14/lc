// https://leetcode.com/problems/find-mode-in-binary-search-tree/
// BST真的全部都是in order traveral！

class Solution {
    int maxCount = 0, prev = -100001, count = 0;
    List<Integer> result = new ArrayList<> ();
    
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
    
    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inorder(root.left);
        
        if(prev == -100001) {
            prev = root.val;
            count = 1;
        } else {
            if(prev == root.val) {
                count++;
            } else {
                prev = root.val;
                count = 1;
            }
        }
        
        if(count == maxCount) {
            result.add(root.val);
        } else if(count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(root.val);
        }
        
        inorder(root.right);
    }
}