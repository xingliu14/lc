// https://leetcode.com/problems/longest-common-prefix/
// 分别按照每一位加上去

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean cont = true;
        while(cont) {
            int index = sb.length();
            char curr = 'x';
            for(int i = 0; i < strs.length; i++) {
                String str = strs[i];
                if(str == null || str.length() - 1 < index) {
                    cont = false;
                    break;
                }
                if(i == 0) {
                    curr = str.charAt(index);
                } else if(str.charAt(index) != curr) {
                    cont = false;
                    break;
                }
            }
            if(cont) {
                sb.append(curr);
            }
        }
        return sb.toString();
    }
}