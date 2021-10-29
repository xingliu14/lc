// https://leetcode.com/problems/determine-if-string-halves-are-alike/
// 简单数数即可

class Solution {
    public boolean halvesAreAlike(String s) {
        int len = s.length() / 2, count = 0;
        s = s.toLowerCase();
        for(int i = 0; i < len; i++) {
            if(isVowel(s.charAt(i))) {
                count++;
            }
            if(isVowel(s.charAt(i + len))) {
                count--;
            }
        }
        return count == 0;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}