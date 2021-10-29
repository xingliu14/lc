// https://leetcode.com/problems/valid-palindrome/
// 就注意用了两个buildin的方程

class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) {
            return false;
        }
        s = s.toLowerCase();
        int head = 0, tail = s.length() - 1;
        while(head < tail) {
            if(!Character.isLetterOrDigit(s.charAt(head))) {
                head++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(tail))) {
                tail--;
                continue;
            }
            if(s.charAt(head) == s.charAt(tail)) {
                head++;
                tail--;
            } else {
                return false;
            }
        }
        return true;
    }
}