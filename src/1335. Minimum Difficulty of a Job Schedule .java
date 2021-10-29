// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
// 老老实实dp，别去想省空间或者时间的骚操作了

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d) {
            return -1;
        }
        
        int jobNum = jobDifficulty.length, maxmin = 0;
        int[][] dp = new int[d][jobNum], diff = new int[jobNum][jobNum];
        
        for(int i = 0; i < jobNum; i++) {
            maxmin = 0;
            for(int j = i; j < jobNum; j++) {
                maxmin = Math.max(maxmin, jobDifficulty[j]);
                diff[i][j] = maxmin;
            }
        }
        
        for(int i = 0; i <= jobNum - d; i++) {
            dp[0][i] = diff[0][i];
        }
        
        for(int i = 1; i < d; i++) {
            for(int j = i; j <= jobNum - d + i; j++) {
                maxmin = Integer.MAX_VALUE;
                for(int k = i - 1; k < j; k++) {
                    maxmin = Math.min(maxmin, dp[i - 1][k] + diff[k + 1][j]);
                }
                dp[i][j] = maxmin;
            }
        }
        
        return dp[d - 1][jobNum - 1];
    }
}