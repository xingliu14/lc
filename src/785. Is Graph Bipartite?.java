// https://leetcode.com/problems/is-graph-bipartite
// bfs和dfs都可以做

class Solution {
    public boolean isBipartite(int[][] graph) {
        int num = graph.length;
        int[] partition = new int[num];
        List<Integer> curr = new ArrayList<> ();
        Set<Integer> seen = new HashSet<> ();
        curr.add(0);
        seen.add(0);
        partition[0] = 1;
        int currSide = 1;
        while(!curr.isEmpty() || seen.size() < num) {
            if(!curr.isEmpty()) {
                List<Integer> next = new ArrayList<> ();
                for(int i : curr) {
                    int[] edges = graph[i];
                    for(int node : edges) {
                        if(partition[node] == currSide) {
                            return false;
                        } else {
                            partition[node] = currSide == 1 ? 2 : 1;
                        }
                        if(!seen.contains(node)) {
                            next.add(node);
                            seen.add(node);
                        }
                    }
                }
                curr = next;
                currSide = currSide == 1 ? 2 : 1;
            } else {
                for(int i = 0; i < num; i++) {
                    if(!seen.contains(i)) {
                        curr.add(i);
                        seen.add(i);
                        break;
                    }
                }
            }
        }
        return true;
    }
}