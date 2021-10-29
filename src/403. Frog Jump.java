// https://leetcode.com/problems/frog-jump/
// bfs，同时再用一个set来存已经访问过的

class Solution {
    private Set<Pair<Integer, Integer>> set, visited;
    
    public boolean canCross(int[] stones) {
        set = new HashSet<> ();
        visited = new HashSet<> ();
        set.add(new Pair<Integer, Integer> (0, 0));
        return findWay(stones);
    }
    
    private boolean findWay(int[] stones) {
        if(set.isEmpty()) {
            return false;
        }
        Set<Pair<Integer, Integer>> tempSet = new HashSet<> ();
        for(Pair<Integer, Integer> pair : set) {
            int index = pair.getKey(), step = pair.getValue();
            if(index == stones.length - 1) {
                return true;
            }
            for(int i = index + 1; i < stones.length; i++) {
                if(stones[i] - stones[index] >= step - 1 && stones[i] - stones[index] <= step + 1) {
                    Pair<Integer, Integer> curr = new Pair<Integer, Integer> (i, stones[i] - stones[index]);
                    if(!visited.contains(curr)) {
                        tempSet.add(curr);
                        visited.add(curr);
                    }
                } else if(stones[i] - stones[index] > step + 1) {
                    break;
                }
            }
        }
        set = tempSet;
        return findWay(stones);
    }
}