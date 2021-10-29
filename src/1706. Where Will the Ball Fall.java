// https://leetcode.com/problems/where-will-the-ball-fall/
// 建好模之后递归即可，注意需要一个path数组来memorize

class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] result = new int[n];
        int[][] path = new int[m][n];
        for(int i = 0; i < n; i++) {
            goThisWay(0, i, grid, path);
        }
        return path[0];
    }
    
    private int goThisWay(int row, int col, int[][] grid, int[][] path) {
        if(path[row][col] != 0) {
            return path[row][col];
        }
        int curr = grid[row][col];
        if((curr == -1 && (col == 0 || grid[row][col - 1] == 1)) || (curr == 1 && (col == grid[0].length - 1 || grid[row][col + 1] == -1))) {
            path[row][col] = -1;
            return -1;
        }
        if(row == grid.length - 1) {
            path[row][col] = col + curr;
            return col + curr;
        }
        path[row][col] = goThisWay(row + 1, col + curr, grid, path);
        return path[row][col];
    }
}