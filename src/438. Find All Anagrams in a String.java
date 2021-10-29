// https://leetcode.com/problems/find-all-anagrams-in-a-string/
// 用char array来存，特别注意charCount不要存重复的

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) {
            return new LinkedList<> ();
        }
        int[] count = new int[26];
        int charCount = 0;
        for(char c : p.toCharArray()) {
            if(count[c - 'a']++ == 0) {
                charCount++;
            }
        }
        List<Integer> result = new LinkedList<> ();
        for(int i = 0; i < s.length(); i++) {
            if(i >= p.length()) {
                int temp = ++count[s.charAt(i - p.length()) - 'a'];
                if(temp == 0) {
                    charCount--;
                } else if(temp == 1) {
                    charCount++;
                }
            }
            int temp = --count[s.charAt(i) - 'a'];
            if(temp == 0) {
                charCount--;
            } else if(temp == -1) {
                charCount++;
            }
            if(charCount == 0) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}