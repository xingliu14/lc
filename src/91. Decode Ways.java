// https://leetcode.com/problems/decode-ways/
// 就分几种情况递归即可

class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) {
            return 1;
        }
        if(s.length() == 1) {
            if(s.charAt(0) <='0' || s.charAt(0) > '9') {
                return 0;
            }
            return 1;
        }
        char curr = s.charAt(0), next = s.charAt(1);
        if(curr == '0') {
            return 0;
        }
        if(curr > '2') {
            return numDecodings(s.substring(1));
        } else if(next == '0') {
            return numDecodings(s.substring(2));
        } else if(curr == '1' || next <= '6') {
            return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
        }
        return numDecodings(s.substring(1));
    }
}