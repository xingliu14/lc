// https://leetcode.com/problems/minimum-window-substring/
// 既然t的顺序不重要，我们就需要把它变成map，然后每一位一位地移动，只需要观察这一位的value对应的值就知道是不是有效位数。然后用一个counter来存所有的有效位数。这样就能one pass。

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<> ();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int head = 0, tail = 0, minLen = Integer.MAX_VALUE, counter = t.length(), minHead = 0;
        while(tail < s.length()) {
            char c = s.charAt(tail);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if(map.get(c) >= 0) {
                counter -= 1;
            }
            tail += 1;
            while(counter == 0) {
                if(tail - head < minLen) {
                    minLen = tail - head;
                    minHead = head;
                }
                char ch = s.charAt(head);
                map.put(ch, map.get(ch) + 1);
                if(map.get(ch) > 0) {
                    counter += 1;
                }
                head += 1;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minHead, minHead + minLen);
    }
}