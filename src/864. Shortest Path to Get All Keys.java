// https://leetcode.com/problems/shortest-path-to-get-all-keys/submissions/
// 死亡bfs，需要存状态判断有没有visited

class Solution {
    int r, c;
    String[] grid;
    public Map<Integer, Integer> visited = new HashMap<> ();
    
    public int shortestPathAllKeys(String[] grid) {
        r = grid.length;
        c = grid[0].length();
        this.grid = grid;
        int target = 0;
        // Pair key: location, value: key status
        List<Pair<Integer, Integer>> curr = new LinkedList<> ();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i].charAt(j) == '@') {
                    Pair<Integer, Integer> start = new Pair<> (i * c + j, 0);
                    curr.add(start);
                    visited.put(i * c + j, 0);
                }
                if(grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    target |= (1 << (grid[i].charAt(j) - 'a'));
                }
            }
        }
        
        int step = 0;
        int[][] dir = new int[][] {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        while(!curr.isEmpty()) {
            step++;
            List<Pair<Integer, Integer>> next = new LinkedList<> ();
            for(Pair<Integer, Integer> pair : curr) {
                int currR = pair.getKey() / c, currC = pair.getKey() % c, currKey = pair.getValue();
                for(int i = 0; i < 4; i++) {
                    int newKey = getNewKey(currR + dir[i][0], currC + dir[i][1], currKey), newLoc = (currR + dir[i][0]) * c + currC + dir[i][1];
                    if(newKey != -1) {
                        if(newKey == target) {
                            return step;
                        }
                        System.out.println(newKey);
                        next.add(new Pair<Integer, Integer> (newLoc, newKey));
                        visited.put(newLoc, newKey);
                    }
                }
            }
            curr = next;
        }
        return -1;
    }
    
    private int getNewKey(int tryR, int tryC, int key) {
        if(tryR < 0 || tryR >= r || tryC < 0 || tryC >= c || grid[tryR].charAt(tryC) == '#') {
            return -1;
        }
        char c = grid[tryR].charAt(tryC);
        int newLoc = tryR * c + tryC, newKey = key;
        if(c == '.' || c == '@') {
            if(!visited.containsKey(newLoc) || ((int)visited.get(newLoc) | key) != visited.get(newLoc)) {
                return newKey;
            }
        } else if(c >= 'a' && c <= 'f') {
            newKey |= 1 << (c - 'a');
            if(!visited.containsKey(newLoc) || ((int)visited.get(newLoc) | newKey) != visited.get(newLoc)) {
                return newKey;
            }
        } else {
            if(((1 << (c - 'A')) & key) != 0) {
                if(!visited.containsKey(newLoc) || ((int)visited.get(newLoc) | key) != visited.get(newLoc)) {
                    return newKey;
                }
            }
        }
        return -1;
    }
}