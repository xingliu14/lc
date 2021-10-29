// https://leetcode.com/problems/valid-anagram/
// 直接计数即可

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        int charCount = 0;
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            if(count[s.charAt(i) - 'a'] == 0) {
                charCount--;
            } else if(count[s.charAt(i) - 'a'] == 1) {
                charCount++;
            }
            count[t.charAt(i) - 'a']--;
            if(count[t.charAt(i) - 'a'] == 0) {
                charCount--;
            } else if(count[t.charAt(i) - 'a'] == -1) {
                charCount++;
            }
        }
        return charCount == 0;
    }
}