// https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
// 这道题从微观考虑很难！从宏观考虑，再分奇偶。偶数很简单，奇数需要优化一下。

class Solution {
    public int minFlips(String s) {
        int len = s.length();
        if(len == 1) {
            return 0;
        }
        if(len % 2 == 1) {
            return forOdd(s);
        } 
        return forEven(s);
    }
    
    public int forOdd(String s) {
        int even = 0, odd = 0, half = s.length() / 2, min = Integer.MAX_VALUE;
        for(int i = 0; i < s.length() - 1; i++) {
            if(i % 2 == 0) {
                even += s.charAt(i) - '0';
            } else {
                odd += s.charAt(i) - '0';
            }
        }
        min = Math.min(half - even + odd, half - odd + even);
        
        int rightEven = 0, rightOdd = 0;
        for(int i = s.length() - 2; i >= 0; i--) {
            if(i % 2 == 0) {
                even -= s.charAt(i) - '0';
                rightOdd += s.charAt(i + 1) - '0';
            } else {
                odd -= s.charAt(i) - '0';
                rightEven += s.charAt(i + 1) - '0';
            }
            min = Math.min(min, Math.min(half - even - rightOdd + odd + rightEven, half - odd - rightEven + even + rightOdd));
        }
        return min;
    }
    
    public int forEven(String s) {
        int even = 0, odd = 0, half = s.length() / 2;
        for(int i = 0; i < s.length(); i++) {
            if(i % 2 == 0) {
                even += s.charAt(i) - '0';
            } else {
                odd += s.charAt(i) - '0';
            }
        }
        
        return Math.min(half - even + odd, half - odd + even);
    }
}