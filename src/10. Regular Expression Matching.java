// https://leetcode.com/problems/regular-expression-matching/
// 使用递归很巧妙的把三种情况表达出来，1：pattern前面是x*，那我可以直接忽略这两个；2：第一个字符match了，但是同时有*在后面，我可以删掉string的第一个，继续往下走；3：pattern只有一个了或者没有*，检查第一个有没有match，再双方减掉1往下走

class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first_char_match = s.length() >= 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if(p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) ||
                (first_char_match && isMatch(s.substring(1), p));
        } else {
            return first_char_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}