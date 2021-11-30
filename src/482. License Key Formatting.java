// https://leetcode.com/problems/license-key-formatting/
// 从后往前

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != '-') {
                if(curr >= k) {
                    sb.append('-');
                    curr = 0;
                }
                sb.append(Character.toUpperCase(s.charAt(i)));
                curr++;
            }
        }
        return sb.reverse().toString();
    }
}