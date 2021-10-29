// https://leetcode.com/problems/binary-search-tree-iterator/
// 奇奇怪怪

class BSTIterator {
    
    private List<Integer> list;
    private int index;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<> ();
        index = 0;
        inOrderTraversal(root);
    }
    
    private void inOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        } else {
            inOrderTraversal(root.left);
            this.list.add(root.val);
            inOrderTraversal(root.right);
            return;
        }
    }
    
    public int next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        return index < list.size();
    }
}