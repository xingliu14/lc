// https://leetcode.com/problems/binary-tree-maximum-path-sum/
// 首先，答案一定会有一个root，也就是level最高的点，通过这个可以写出getMaxRootSum方程，然后对这两边分别向下走，也就是getMaxOneWaySum。注意这两个方程都只确保现在这个点加进来。然后按照一层一层遍历下去。如果对于每个TreeNode可以把对于的oneway最大值存下来可以提升速度。

class Solution {
    public int maxPathSum(TreeNode root) {
        int result = Integer.MIN_VALUE;
        List<TreeNode> nextNodes = new ArrayList<> ();
        nextNodes.add(root);
        while(!nextNodes.isEmpty()) {
            TreeNode currNode = nextNodes.get(0);
            nextNodes.remove(0);
            result = Math.max(result, getMaxRootSum(currNode));
            if(currNode.left != null) {
                nextNodes.add(currNode.left);
            }
            if(currNode.right != null) {
                nextNodes.add(currNode.right);
            }
        }
        return result;
    }
    
    private int getMaxRootSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return root.val + Math.max(0, getMaxOneWaySum(root.left)) + Math.max(0, getMaxOneWaySum(root.right));
    }
    
    private int getMaxOneWaySum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return root.val + Math.max(0, Math.max(getMaxOneWaySum(root.left), getMaxOneWaySum(root.right)));
    }
}