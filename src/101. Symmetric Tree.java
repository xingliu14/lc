// https://leetcode.com/problems/symmetric-tree/
// 递归的方法比较简单。对于循环解法，注意我们只需从上往下一层一层比较，所以直接poll然后push子node即可。特别注意ArrayDeque是不允许null值的，所以这里不能用ArrayDeque！

 // recursive solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSubnodeSymmetric(root.left, root.right);
    }
    
    private boolean isSubnodeSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null ^ right == null) {
            return false;
        }
        return left.val == right.val && isSubnodeSymmetric(left.left, right.right) && isSubnodeSymmetric(left.right, right.left);
    }
}

// iterate solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> stack = new LinkedList<> ();
        stack.offer(root);
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode t1 = stack.poll();
            TreeNode t2 = stack.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null ^ t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            stack.offer(t1.left);
            stack.offer(t2.right);
            stack.offer(t1.right);
            stack.offer(t2.left);
        }
        return true;
    }
}