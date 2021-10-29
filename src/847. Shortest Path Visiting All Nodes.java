// https://leetcode.com/problems/shortest-path-visiting-all-nodes/
// 很多时候bfs/dfs真的就是最好的路，只不过要好好实现。另外Pair是可以深度比较的，真好用。

class Solution {
    public int shortestPathLength(int[][] graph) {
        int size = graph.length, target = (1 << size) - 1, step = 0;
        List<Pair<Integer, Integer>> curr = new LinkedList<> ();
        Set<Pair<Integer, Integer>> visited = new HashSet<> ();
        for(int i = 0; i < size; i++) {
            curr.add(new Pair<Integer, Integer> (i, 1 << i));
        }
        while(!curr.isEmpty()) {
            List<Pair<Integer, Integer>> next = new LinkedList<> ();
            for(Pair<Integer, Integer> pair : curr) {
                if(pair.getValue() == target) {
                    return step;
                }
                int currNode = pair.getKey();
                for(int nextNode : graph[currNode]) {
                    int nextPath = pair.getValue() | (1 << nextNode);
                    Pair<Integer, Integer> nextPair = new Pair<Integer, Integer> (nextNode, nextPath);
                    if(visited.contains(nextPair)) {
                        continue;
                    }
                    visited.add(nextPair);
                    next.add(nextPair);
                }
            }
            curr = next;
            step++;
        }
        return -1;
    }
}