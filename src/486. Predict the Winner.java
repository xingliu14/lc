// https://leetcode.com/problems/predict-the-winner/
// 标准dp

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        for(int i = 1; i < len; i++) {
            for(int j = 0; i + j < len; j++) {
                dp[j][i + j] = Math.max(nums[j] - dp[j + 1][i + j], nums[i + j] - dp[j][i + j - 1]);
            }
        }
        
        return dp[0][len - 1] >= 0;
    }
}