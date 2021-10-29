// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
// 树主要是难往上走，所以我们直接搞一个parents map来记录parent，把它看成图来bfs

class Solution {
    
    private Map<TreeNode, TreeNode> parents;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parents = new HashMap<> ();
        dfs(root, null);
        List<TreeNode> list = new LinkedList<> ();
        Set<TreeNode> seen = new HashSet<> ();
        list.add(target);
        seen.add(target);
        int distance = 0;
        while(!list.isEmpty()) {
            if(distance == K) {
                List<Integer> result = new ArrayList<> ();
                for(TreeNode node : list) {
                    result.add(node.val);
                }
                return result;
            } else {
                List<TreeNode> temp = new LinkedList<> ();
                for(TreeNode node : list) {
                    if(node.left != null && !seen.contains(node.left)) {
                        seen.add(node.left);
                        temp.add(node.left);
                    }
                    if(node.right != null && !seen.contains(node.right)) {
                        seen.add(node.right);
                        temp.add(node.right);
                    }
                    if(parents.get(node) != null && !seen.contains(parents.get(node))) {
                        seen.add(parents.get(node));
                        temp.add(parents.get(node));
                    }
                }
                list = temp;
                distance++;
            }
        }
        return new ArrayList<> ();
    }
    
    private void dfs(TreeNode child, TreeNode parent) {
        if(child != null) {
            parents.put(child, parent);
            dfs(child.left, child);
            dfs(child.right, child);
        }
        return;
    }
}