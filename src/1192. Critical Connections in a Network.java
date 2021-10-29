// https://leetcode.com/problems/critical-connections-in-a-network/
// 这种设rank的方法很适合图。特别注意！如果在递归遍历collection的时候操作它，那就会有concurrent的问题，所以这里用了两个connection的数据结构，我们只修改一个。虽然会略微增长复杂度，但没有本质区别。

class Solution {
    private Map<Integer, Set<Integer>> map;
    HashSet<List<Integer>> connectionsSet;
    private int[] rank;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        map = new HashMap<> ();
        for(List<Integer> conn : connections) {
            int node1 = conn.get(0), node2 = conn.get(1);
            Set set1 = map.getOrDefault(node1, new HashSet<> ());
            Set set2 = map.getOrDefault(node2, new HashSet<> ());
            set1.add(node2);
            set2.add(node1);
            map.put(node1, set1);
            map.put(node2, set2);
        }
        connectionsSet = new HashSet<> (connections);
        
        rank = new int[n];
        Arrays.fill(rank, -2);
        
        dfs(0, 0);
        
        return new ArrayList<> (connectionsSet);
    }
    
    private int dfs(int node, int depth) {
        int minRank = depth;
        if(rank[node] != -2) {
            return rank[node];
        }
        rank[node] = depth;
        Set<Integer> neighbors = map.get(node);
        for(Iterator<Integer> i = neighbors.iterator(); i.hasNext();) {
            int neighbor = i.next();
            if(rank[neighbor] == depth - 1) {
                continue;
            }
            int nextMinRank = dfs(neighbor, depth + 1);
            if(nextMinRank <= depth) {
                connectionsSet.remove(Arrays.asList(node, neighbor));
                connectionsSet.remove(Arrays.asList(neighbor, node));
                minRank = Math.min(minRank, nextMinRank);
            }
        }
        return minRank;
    }
}