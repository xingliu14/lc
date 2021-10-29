// https://leetcode.com/problems/max-area-of-island/
// 标准dfs

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length, max = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j, 0));
                }
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid, int row, int col, int count) {
        grid[row][col] = 0;
        count++;
        if(row > 0 && grid[row - 1][col] == 1) {
            count += dfs(grid, row - 1, col, 0);
        }
        if(row < grid.length - 1 && grid[row + 1][col] == 1) {
            count += dfs(grid, row + 1, col, 0);
        }
        if(col > 0 && grid[row][col - 1] == 1) {
            count += dfs(grid, row, col - 1, 0);
        }
        if(col < grid[0].length - 1 && grid[row][col + 1] == 1) {
            count += dfs(grid, row, col + 1, 0);
        }
        return count;
    }
}