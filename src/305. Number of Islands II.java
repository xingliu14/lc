// https://leetcode.com/problems/number-of-islands-ii/
// Union Find的变种，注意是怎么考虑init和union的，然后用一维表示二维的时候要注意啊！然后不一定需要init完整的array，可以用map on demand插入。

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new LinkedList<> ();
        UnionFind uf = new UnionFind();
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] pos : positions) {
            int x = pos[0], y = pos[1], target = x * n + y;
            if(!uf.isValid(target)) {
                uf.initLand(target);
                for(int i = 0; i < 4; i++) {
                    int adjTarget = (x + dir[i][0]) * n + (y + dir[i][1]);
                    if(x + dir[i][0] >= 0 && x + dir[i][0] < m && y + dir[i][1] >= 0 && y + dir[i][1] < n && uf.isValid(adjTarget)) {
                        uf.union(target, adjTarget);
                    }
                }
            }
            
            result.add(uf.getCount());
        }
        
        return result;
    }
    
    class UnionFind {
        private int count;
        private Map<Integer, Integer> parents;
        private Map<Integer, Integer> ranks;
        
        public UnionFind() {
            count = 0;
            parents = new HashMap<> ();
            ranks = new HashMap<> ();
        }
        
        public boolean isValid(int target) {
            return parents.containsKey(target);
        }
        
        public void initLand(int land) {
            parents.put(land, land);
            ranks.put(land, 0);
            count++;
        }
        
        private int find(int target) {
            int parent = parents.get(target);
            if(parent != target) {
                return find(parent);
            }
            return parent;
        }
        
        public void union(int i, int j) {
            int i_parent = find(i), j_parent = find(j);
            if(i_parent != j_parent) {
                if(ranks.get(i_parent) < ranks.get(j_parent)) {
                    parents.put(i_parent, j_parent);
                } else if(ranks.get(i_parent) > ranks.get(j_parent)) {
                    parents.put(j_parent, i_parent);
                } else {
                    parents.put(i_parent, j_parent);
                    ranks.put(j_parent, ranks.get(j_parent) + 1);
                }
                count--;
            }
        }
        
        public int getCount() {
            return count;
        }
    }
}