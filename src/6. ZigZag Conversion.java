// https://leetcode.com/problems/zigzag-conversion/
// 本质是数学问题，一个batch一个batch的处理，然后第一排和最后一排只有一个，中间排可能有两个（需要检查边界）

class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0) {
            return "";
        }
        if(numRows == 1) {
            return s;
        }
        int batch = 2 * (numRows - 1);
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < numRows; row++) {
            for(int i = 0; i <= (s.length() - 1) / batch; i++) {
                if(row == 0) {
                    sb.append(s.charAt(i * batch));
                } else if(row == numRows - 1) {
                    if(i * batch + numRows - 1 < s.length()) {
                        sb.append(s.charAt(i * batch + numRows - 1));
                    }
                } else {
                    if(i * batch + row < s.length()) {
                        sb.append(s.charAt(i * batch + row));
                    }
                    if((i + 1) * batch - row < s.length()) {
                        sb.append(s.charAt((i + 1) * batch - row));
                    }
                }
            }
        }
        return sb.toString();
    }
}