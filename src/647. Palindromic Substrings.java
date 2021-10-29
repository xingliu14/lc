// https://leetcode.com/problems/palindromic-substrings/
// 利用palindrom的特性，从中间往外找

class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            result++;
            for(int j = 1; i - j >= 0 && i + j < s.length(); j++) {
                if(s.charAt(i - j) == s.charAt(i + j)) {
                    result++;
                } else {
                    break;
                }
            }
        }
        for(int i = 0; i < s.length() - 1; i++) {
            for(int j = 1; i - j + 1 >= 0 && i + j < s.length(); j++) {
                if(s.charAt(i - j + 1) == s.charAt(i + j)) {
                    result++;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}