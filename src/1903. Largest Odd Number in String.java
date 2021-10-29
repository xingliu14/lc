// https://leetcode.com/problems/largest-odd-number-in-string/

class Solution {
    public String largestOddNumber(String num) {
        int index = num.length() - 1;
        while(index >= 0) {
            if((num.charAt(index) - '0') % 2 == 1) {
                break;
            }
            index--;
        }
        if(index == -1) {
            return "";
        }
        return num.substring(0, index + 1);
    }
}