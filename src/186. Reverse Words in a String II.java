// https://leetcode.com/problems/reverse-words-in-a-string-ii/
// inplace那就2 pass

class Solution {
    public void reverseWords(char[] s) {
        for(int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        int head = 0, tail = 0;
        while(head < s.length) {
            while(tail != s.length && s[tail] != ' ') {
                tail++;
            }
            int tempTail = tail - 1;
            while(head < tempTail) {
                char temp = s[head];
                s[head] = s[tempTail];
                s[tempTail] = temp;
                head++;
                tempTail--;
            }
            tail++;
            head = tail;
        }
        return;
    }
}