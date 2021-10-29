// https://leetcode.com/problems/maximal-square/
// 如果是正方形的话就很容易dp了。

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length, max = 0;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++) {
            if(matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for(int i = 0; i < col; i++) {
            if(matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = 1;
            }
        }
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}