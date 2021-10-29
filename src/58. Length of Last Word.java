// https://leetcode.com/problems/length-of-last-word/
// 用两个数字存

class Solution {
    public int lengthOfLastWord(String s) {
        int last = 0, curr = 0;
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                last = curr == 0 ? last : curr;
                curr = 0;
            } else {
                curr += 1;
            }
        }
        return curr == 0 ? last : curr;
    }
}