// https://leetcode.com/problems/edit-distance/
// 经典好题啊！do的转移方程分别对应着三种操作

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] cache = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++) {
            cache[i][0] = i;
        }
        for(int j = 0; j <= len2; j++) {
            cache[0][j] = j;
        }
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cache[i][j] = cache[i - 1][j - 1];
                } else {
                    cache[i][j] = 1 + Math.min(cache[i - 1][j - 1], Math.min(cache[i][j - 1], cache[i - 1][j]));
                }
            }
        }
        return cache[len1][len2];
    }
}