// https://leetcode.com/problems/path-sum-ii/
// 找所有可能的题就要用backtrack，注意每一次加数字进去都要再把它退出来


class Solution {
    
    public List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.result = new ArrayList<> ();
        if(root == null) {
            return result;
        }
        helper(root, sum, new ArrayList<Integer> ());
        return result;
    }
    
    private void helper(TreeNode currNode, int sum, List<Integer> currList) {
        if(currNode.left == null && currNode.right == null) {
            if(currNode.val == sum) {
                currList.add(currNode.val);
                this.result.add(new ArrayList<> (currList));
                currList.remove(currList.size() - 1);
            }
            return;
        }
        if(currNode.left != null) {
            currList.add(currNode.val);
            helper(currNode.left, sum - currNode.val, currList);
            currList.remove(currList.size() - 1);
        }
        if(currNode.right != null) {
            currList.add(currNode.val);
            helper(currNode.right, sum - currNode.val, currList);
            currList.remove(currList.size() - 1);
        }
    }
}