// https://leetcode.com/problems/maximum-value-after-insertion/
// 分正负分别考虑即可

class Solution {
    public String maxValue(String n, int x) {
        if(n.charAt(0) == '-') {
            for(int i = 1; i < n.length(); i++) {
                if(n.charAt(i) - '0' > x) {
                    return n.substring(0, i) + x + n.substring(i);
                }
            }
        } else {
            for(int i = 0; i < n.length(); i++) {
                if(n.charAt(i) - '0' < x) {
                    return n.substring(0, i) + x + n.substring(i);
                }
            }
        }
        return n + x;
    }
}