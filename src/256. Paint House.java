// https://leetcode.com/problems/paint-house/
// 省空间dp

class Solution {
    public int minCost(int[][] costs) {
        int houseNum = costs.length;
        int[] dp = new int[3];
        dp[0] = costs[0][0];
        dp[1] = costs[0][1];
        dp[2] = costs[0][2];
        for(int i = 1; i < houseNum; i++) {
            int[] nextDp = new int[3];
            nextDp[0] = Math.min(dp[1], dp[2]) + costs[i][0];
            nextDp[1] = Math.min(dp[0], dp[2]) + costs[i][1];
            nextDp[2] = Math.min(dp[0], dp[1]) + costs[i][2];
            dp = nextDp;
        }
        
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}