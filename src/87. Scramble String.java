// https://leetcode.com/problems/scramble-string/
// 这道题的定义看上去巨他妈复杂，这时候就需要递归出马了，定义好最基本的情况，然后分割递归

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }
        
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a'] += 1;
            letters[s2.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i]!=0) {
                return false;
            }
        }
    
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i))
             && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) 
             && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) {
                return true;
            }
        }
        return false;
    }
}