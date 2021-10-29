// https://leetcode.com/problems/number-of-boomerangs/
// 暴力搞

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for(int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<> ();
            for(int j = 0; j < points.length; j++) {
                if(j != i) {
                    int dis = (int) Math.pow(points[i][0] - points[j][0], 2) + (int) Math.pow(points[i][1] - points[j][1], 2);
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
            }
            for(int v : map.values()) {
                result += v * (v - 1);
            }
        }
        return result;
    }
}