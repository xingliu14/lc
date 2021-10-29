// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
// 第一次写UnionFind，其实还有路径压缩的优化

class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.getComp();
    }
    
    class UnionFind {
        int[] parent;
        int[] rank;
        int comp;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            comp = n;
            
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        public int find(int node) {
            if(parent[node] != node) {
                return find(parent[node]);
            }
            return parent[node];
        }
        
        public void union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);
            if(parent1 != parent2) {
                if(rank[parent1] < rank[parent2]) {
                    parent[parent1] = parent2;
                } else if(rank[parent1] > rank[parent2]) {
                    parent[parent2] = parent1;
                } else {
                    parent[parent2] = parent1;
                    rank[parent1]++;
                }
                comp--;
            }
        }
        
        public int getComp() {
            return comp;
        }
    }
}