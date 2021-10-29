// https://leetcode.com/problems/stone-game-viii/
// 死亡对称性dp，而且还有超级cache简化遍历过程

class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length, currSum = 0, prevMax = Integer.MIN_VALUE;
        int[] dp = new int[n], sum = new int[n];
        
        for(int i = 0; i < n; i++) {
            currSum += stones[i];
            sum[i] = currSum;
        }
        
        // dp[i] is max score first player can get from i to n
        dp[n - 1] = 0;
        dp[n - 2] = sum[n - 1];
        prevMax = Math.max(sum[n - 1] - dp[n - 1], sum[n - 2] - dp[n - 2]);
        
        for(int i = n - 3; i >= 0; i--) {
            int max = Math.max(prevMax, sum[i + 1] - dp[i + 1]);
            dp[i] = max;
            prevMax = max;
        }
        
        return dp[0];
    }
}