// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
// 余数一样的统一分类

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<> ();
        int result = 0;
        for(int t : time) {
            int res = t % 60;
            map.put(res, map.getOrDefault(res, 0) + 1);
        }
        for(int t : map.keySet()) {
            if(t <= 30) {
                if(t == 0 || t == 30) {
                    result += (map.get(t) * (map.get(t) - 1)) / 2;
                } else {
                    result += map.get(t) * map.getOrDefault(60 - t, 0);
                }
            }
        }
        return result;
    }
}