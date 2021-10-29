// https://leetcode.com/problems/first-unique-character-in-a-string/
// 直接用Map

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<> ();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i : map.values()) {
            if(i != -1) {
                min = Math.min(min, i);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}