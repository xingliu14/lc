// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
// sliding window加hashmap

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) {
            return 0;
        }
        int max = 0;
        Map<Character, Integer> map = new HashMap<> ();
        int head = 0, tail = 0;
        while(tail < s.length()) {
            char c = s.charAt(tail);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
                while(map.size() > k) {
                    char toRemove = s.charAt(head);
                    if(map.get(toRemove) == 1) {
                        map.remove(toRemove);
                    } else {
                        map.put(toRemove, map.get(toRemove) - 1);
                    }
                    head++;
                }
            }
            tail++;
            max = Math.max(max, tail - head);
        }
        
        return max;
    }
}