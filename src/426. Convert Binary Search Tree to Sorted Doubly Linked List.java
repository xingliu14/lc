// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
// 第一个是我写的解法，第二个是官方解法

class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        return trans(root).getKey();
    }
    
    private Pair<Node, Node> trans(Node root) {
        if(root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return new Pair(root, root);
        } 
        if(root.left == null) {
            Pair<Node, Node> pair = trans(root.right);
            root.right = pair.getKey();
            root.left = pair.getValue();
            pair.getKey().left = root;
            pair.getValue().right = root;
            return new Pair(root, pair.getValue());
        }
        if(root.right == null) {
            Pair<Node, Node> pair = trans(root.left);
            root.left = pair.getValue();
            root.right = pair.getKey();
            pair.getValue().right = root;
            pair.getKey().left = root;
            return new Pair(pair.getKey(), root);
        }
        Pair<Node, Node> leftPair = trans(root.left), rightPair = trans(root.right);
        leftPair.getValue().right = root;
        rightPair.getKey().left = root;
        root.left = leftPair.getValue();
        root.right = rightPair.getKey();
        leftPair.getKey().left = rightPair.getValue();
        rightPair.getValue().right = leftPair.getKey();
        return new Pair(leftPair.getKey(), rightPair.getValue());
    }
}

class Solution {
  // the smallest (first) and the largest (last) nodes
  Node first = null;
  Node last = null;

  public void helper(Node node) {
    if (node != null) {
      // left
      helper(node.left);
      // node 
      if (last != null) {
        // link the previous node (last)
        // with the current one (node)
        last.right = node;
        node.left = last;
      }
      else {
        // keep the smallest node
        // to close DLL later on
        first = node;
      }
      last = node;
      // right
      helper(node.right);
    }
  }

  public Node treeToDoublyList(Node root) {
    if (root == null) return null;

    helper(root);
    // close DLL
    last.right = first;
    first.left = last;
    return first;
  }
}