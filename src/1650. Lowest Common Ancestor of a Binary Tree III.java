// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
// 有了parent更方便了

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> parents = new HashSet<> ();
        Node curr = p;
        while(curr != null) {
            parents.add(curr);
            curr = curr.parent;
        }
        curr = q;
        while(curr != null) {
            if(parents.contains(curr)) {
                return curr;
            }
            curr = curr.parent;
        }
        
        return null;
    }
}