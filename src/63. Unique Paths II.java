// https://leetcode.com/problems/unique-paths-ii/
// 只需注意初始化dp的时候看看是不是stuck即可

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        boolean stuck = false;
        for(int i = 0; i < col; i++) {
            if(obstacleGrid[0][i] != 1 && !stuck) {
                dp[0][i] = 1;
            } else {
                stuck = true;
            }
        }
        stuck = false;
        for(int i = 0; i < row; i++) {
            if(obstacleGrid[i][0] != 1 && !stuck) {
                dp[i][0] = 1;
            } else {
                stuck = true;
            }
        }
        
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[row - 1][col - 1];
    }
}