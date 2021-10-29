// https://leetcode.com/problems/reverse-string/
// 双指针

class Solution {
    public void reverseString(char[] s) {
        int head = 0, tail = s.length - 1;
        while(head < tail) {
            char tmp = s[head];
            s[head] = s[tail];
            s[tail] = tmp;
            tail--;
            head++;
        }
    }
}