// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// 首先用一个HashMap存一个Character上一次出现在哪里，然后用temp表示以现在为结束，最长的多少，如果现在的之前出现过，那就看限制是不限现在这个character。核心就是DP，还是有些巧妙的。

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0, temp = 0;
        Map<Character, Integer> map = new HashMap<> ();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(!map.containsKey(c)) {
                temp += 1;
            } else {
                temp = Math.min(temp + 1, i - map.get(c));
            }
            map.put(c, i);
            result = Math.max(result, temp);
        }
        return result;
    }
}