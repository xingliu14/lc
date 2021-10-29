// https://leetcode.com/problems/excel-sheet-column-number/
// 主要就是static需要放在外面

class Solution {
    static int batch = 26;
    
    public int titleToNumber(String s) {
        int result = 0, len = s.length();
        for(int i = 0; i < len; i++) {
            result += (s.charAt(i) - 'A' + 1) * Math.pow(batch, len - 1 - i);
        }
        return result;
    }
}