// https://leetcode.com/problems/count-square-submatrices-with-all-ones/
// 既然他要算正方形，就不要麻烦去搞长方形了！而且是三合一！

class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        
        int result = 0;
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == 1) {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j -1])) + 1;
                    }
                    result += dp[i][j];
                }
            }
        }
        
        return result;
    }
}