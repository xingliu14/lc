// https://leetcode.com/problems/longest-valid-parentheses/
// dp的经典应用，只有遇到了')'才更新，然后有可能和前一个更新，或者和前面很多更新，和前面很多的情况还要把在之前的加上拼在一起。

class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                } else if(i > dp[i - 1] && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
}