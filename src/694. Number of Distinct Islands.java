// https://leetcode.com/problems/number-of-distinct-islands/
// dfs的过程中，还需要encode路径，并且要保证能区分路径

class Solution {
    public int numDistinctIslands(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        Set<String> islandSet = new HashSet<> ();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 0, 0);
                    islandSet.add(sb.toString());
                }
            }
        }
        return islandSet.size();
    }
    
    private void dfs(int[][] grid, int row, int col, StringBuilder sb, int x, int y) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return;
        }
        grid[row][col] = 0;
        sb.append("" + x + y + ",");
        dfs(grid, row - 1, col, sb, -1, 0);
        sb.append("|");
        dfs(grid, row + 1, col, sb, 1, 0);
        sb.append("|");
        dfs(grid, row, col - 1, sb, 0, -1);
        sb.append("|");
        dfs(grid, row, col + 1, sb, 0, 1);
        sb.append("|");
    }
}