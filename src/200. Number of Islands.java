// 可以直接bfs消除，也可以Union-Find

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    eliminate(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void eliminate(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = '0';
        if(i - 1 >= 0 && grid[i - 1][j] == '1') {
            eliminate(grid, i - 1, j);
        }
        if(i + 1 < grid.length && grid[i + 1][j] == '1') {
            eliminate(grid, i + 1, j);
        }
        if(j - 1 >= 0 && grid[i][j - 1] == '1') {
            eliminate(grid, i, j - 1);
        }
        if(j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            eliminate(grid, i, j + 1);
        }
        return;
    }
}