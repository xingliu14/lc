// https://leetcode.com/problems/find-leaves-of-binary-tree/
// 不需要一次就把一行找到！每次找到高度再往对应的List加上

class Solution {
    
    private List<List<Integer>> solution;
    
    private int getHeight(TreeNode root) {
        
        // return -1 for null nodes
        if (root == null) {
            return -1;
        }
        
        // first calculate the height of the left and right children
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        
        if (this.solution.size() == currHeight) {
            this.solution.add(new ArrayList<>());
        }
        
        this.solution.get(currHeight).add(root.val);
        
        return currHeight;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        this.solution = new ArrayList<>();
        
        getHeight(root);
        
        return this.solution;
    }
}