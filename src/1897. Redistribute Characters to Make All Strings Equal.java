// https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
// 简单

class Solution {
    public boolean makeEqual(String[] words) {
        int size = words.length;
        Map<Character, Integer> map = new HashMap<> ();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        
        for(int count : map.values()) {
            if(count % size != 0) {
                return false;
            }
        }
        
        return true;
    }
}