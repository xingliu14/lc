// https://leetcode.com/problems/coin-change-2/
// 这个dp有点骚，用backtrack的话直接做会TLE，可能需要memory

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}