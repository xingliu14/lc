// https://leetcode.com/problems/count-sub-islands/
// 注意即使return false了也要把整个岛走完！

class Solution {
    Set<Integer> visited;
    int m, n;
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        visited = new HashSet<> ();
        int count = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid2[i][j] == 1 && !visited.contains(i * n + j) && dfs(grid1, grid2, i, j)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean dfs(int[][] g1, int[][] g2, int r, int c) {
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited.add(r * n + c);
        boolean flag = true;
        if(g1[r][c] == 0) {
            flag = false;
        }
        
        for(int i = 0; i < 4; i++) {
            int nr = r + dir[i][0], nc = c + dir[i][1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && g2[nr][nc] == 1 && !visited.contains(nr * n + nc)) {
                if(!dfs(g1, g2, nr, nc)) {
                    flag = false;
                }
            }
        }
        
        return flag;
    }
}