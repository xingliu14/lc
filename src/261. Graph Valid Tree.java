// https://leetcode.com/problems/graph-valid-tree/
// 首先确定是Tree的条件，1：全连接，2：无环。然后确定没有宏观的可以直接判断的方法，接下来就是dfs，而且注意递归的参数保证不会回头。

class Solution {
    
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private Set<Integer> seen = new HashSet<>();
    
    
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length != n - 1) {
            return false;
        }
        
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        // We return true iff no cycles were detected,
        // AND the entire graph has been reached.
        return dfs(0, -1) && seen.size() == n;   
    }
    
    public boolean dfs(int node, int parent) {
        if (seen.contains(node)) return false;
        seen.add(node);
        for (int neighbour : adjacencyList.get(node)) {
            if (parent != neighbour) {
                boolean result = dfs(neighbour, node);
                if (!result) return false;
            }
        }
        return true;
    }
}