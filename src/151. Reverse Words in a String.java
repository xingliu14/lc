// https://leetcode.com/problems/reverse-words-in-a-string/
// 很简单，稍微注意一下优化

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(), result = new StringBuilder();
        for(int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if(c != ' ') {
                sb.append(c);
            }
            if(c == ' ' || i == s.toCharArray().length - 1) {
                if(sb.length() != 0) {
                    result.insert(0, " " + sb.toString());
                    sb.setLength(0);
                }
            }
        }
        return result.substring(1);
    }
}