// https://leetcode.com/problems/distinct-subsequences/
// 这道题可以用backtrack，但是需要考虑memorize我还没想明白，不过dp也能用到这道题，遇到一个对上的，可以选择使用或者不使用。

class Solution {
    public int numDistinct(String s, String t) {
        int s_len = s.length(), t_len = t.length();
        int[][] dp = new int[t_len + 1][s_len + 1];
        for(int i = 0; i <= s_len; i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i <= t_len; i++) {
            for(int j = 1; j <= s_len; j++) {
                if(s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t_len][s_len];
    }
}