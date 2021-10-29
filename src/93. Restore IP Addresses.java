// https://leetcode.com/problems/restore-ip-addresses/
// 既然是找全部组合，那就还是考虑backtracking。先设置几个return情况，然后找目前有可能的数加进去，进入下一层。

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<> ();
        int len = s.length();
        if(len < 4 || len > 12) {
            return result;
        }
        helper(s, 0, result, new StringBuilder(), 0);
        return result;
    }
    
    private void helper(String s, int index, List<String> result, StringBuilder sb, int count) {
        if(count == 4) {
            if(index == s.length()) {
                result.add(sb.toString());
                return;
            }
            else {
                return;
            }
        }
        if(3 * (4 - count) < s.length() - index) {
            return;
        }
        for(int i = 1; i <= 3 && index + i <= s.length(); i++) {
            if(isValidNum(s.substring(index, index + i))) {
                int addLen = 0;
                if(count != 0) {
                    sb.append('.');
                    addLen += 1;
                }
                sb.append(s.substring(index, index + i));
                addLen += i;
                helper(s, index + i, result, sb, count + 1);
                sb.setLength(sb.length() - addLen);
            }
        }
    }
    
    private boolean isValidNum(String s) {
        if(s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}