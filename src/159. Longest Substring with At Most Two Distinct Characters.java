// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
// 简简单单的sliding window

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0, head = 0;
        Map<Character, Integer> map = new HashMap<> ();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.size() < 2) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                max = Math.max(max, i - head);
                while(map.size() == 2) {
                    char curr = s.charAt(head);
                    int currCount = map.get(curr);
                    if(currCount == 1) {
                        map.remove(curr);
                    } else {
                        map.put(curr, currCount - 1);
                    }
                    head++;
                }
                map.put(c, 1);
            }
        }
        return Math.max(max, s.length() - head);
    }
}