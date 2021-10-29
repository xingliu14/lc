// https://leetcode.com/problems/longest-palindromic-substring/
// 看到求最值想到用dp。注意需要两个循环初始化1和2的情况，再双重循环剩下的情况

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        int result = 1, index = 0;
        Boolean[][] dp = new Boolean[s.length()][s.length()];

        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for(int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if(dp[i][i + 1] && result < 2) {
                result = 2;
                index = i + 1;
            }
        }

        for(int j = 2; j < s.length(); j++) {
            for(int i = 0; i < j - 1; i++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if(dp[i][j] && j - i + 1 > result) {
                    result = j - i + 1;
                    index = j;
                }
            }
        }

        return s.substring(index - result + 1, index + 1);
    }
}