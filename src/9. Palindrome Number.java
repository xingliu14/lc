// https://leetcode.com/problems/palindrome-number/
// 只需要连续检查两下即可覆盖奇数长度和偶数长度的情况

class Solution {
    public boolean isPalindrome(int x) {
        int temp = 0, digit = 0;
        if(x == 0) {
            return true;
        }
        if(x < 0 || x % 10 == 0) {
            return false;
        }
        while(x > temp) {
            digit = x % 10;
            temp = temp * 10 + digit;
            if(temp == x) {
                return true;
            }
            x = x / 10;
            if(temp == x) {
                return true;
            }
        }
        return false;
    }
}