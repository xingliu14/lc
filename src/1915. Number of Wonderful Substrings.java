// https://leetcode.com/problems/number-of-wonderful-substrings/
// 我写的巨屌的位运算，只可惜TLE

class Solution {
    public long wonderfulSubstrings(String word) {
        int curr = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<> ();
        map.put(0, 1);
        for(char c : word.toCharArray()) {
            curr ^= 1 << (c - 'a' + 1);
            for(int prev : map.keySet()) {
                int tmp = prev ^ curr;
                if(Integer.bitCount(tmp) <= 1) {
                    result += map.get(prev);
                }
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return result;
    }
}