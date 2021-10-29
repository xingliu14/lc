// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
// 我本来也在按照前一题的思路，但是感觉很复杂，因为未知太多了。再回头想一想，这不就是level order traversal吗，不过似乎不是constant space

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        List<Node> currLevel = new ArrayList<> ();
        currLevel.add(root);
        while(!currLevel.isEmpty()) {
            int len = currLevel.size();
            Node currNode = currLevel.get(0);
            currLevel.remove(0);
            for(int i = 0; i < len; i++) {
                if(currNode.left != null) {
                    currLevel.add(currNode.left);
                }
                if(currNode.right != null) {
                    currLevel.add(currNode.right);
                }
                if(i != len - 1) {
                    Node nextNode = currLevel.get(0);
                    currLevel.remove(0);
                    currNode.next = nextNode;
                    currNode = nextNode;
                }
            }
        }
        return root;
    }
}