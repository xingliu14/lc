// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// dp

class Solution {
    
    private int[][] dp;
    
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length, max = 0;
        dp = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                max = Math.max(max, findMax(i, j, matrix));
            }
        }
        return max;
    }
    
    private int findMax(int r, int c, int[][] m) {
        if(dp[r][c] != 0) {
            return dp[r][c];
        }
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int max = 1;
        for(int[] d : dir) {
            if(r + d[0] >= 0 && r + d[0] < m.length && c + d[1] >= 0 && c + d[1] < m[0].length && m[r][c] < m[r + d[0]][c + d[1]]) {
                max = Math.max(max, findMax(r + d[0], c + d[1], m) + 1);
            }
        }
        dp[r][c] = max;
        return max;
    }
}