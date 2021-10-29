// https://leetcode.com/problems/guess-number-higher-or-lower-ii/
// 在数字很多的情况下情况错综复杂，就想简单的情况（1，2个数字），再找到转移方程，dp算法便应运而生。

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1; i < n; i++) {
            dp[i][i + 1] = i;
        }
        for(int i = 2; i < n; i++) {
            for(int j = 1; j + i <= n; j++) {
                int min = Integer.MAX_VALUE;
                for(int k = j + 1; k < j + i; k++) {
                    min = Math.min(k + Math.max(dp[j][k - 1], dp[k + 1][j + i]), min);
                }
                dp[j][j + i] = min;
            }
        }
        
        return dp[1][n];
    }
}