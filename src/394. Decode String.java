// https://leetcode.com/problems/decode-string/
// 可以用stack也可以用递归。stack比较直观一点。每次用一个新的StringBuilder比较容易。

class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<String> strStack = new ArrayDeque<> ();
        Deque<Integer> numStack = new ArrayDeque<> ();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int num = c - '0';
                while(s.charAt(++i) != '[') {
                    num = num * 10 + s.charAt(i) - '0';
                }
                numStack.push(num);
                strStack.push(sb.toString());
                sb = new StringBuilder();
            } else if(c == ']') {
                int repeat = numStack.pop();
                String prev = strStack.pop();
                for(int j = 0; j < repeat; j++) {
                    prev += sb.toString();
                }
                sb = new StringBuilder(prev);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}