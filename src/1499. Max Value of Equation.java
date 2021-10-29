// https://leetcode.com/problems/max-value-of-equation/
// 我现在用PriorityQueue用得出神入化

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<> (
            (a, b) -> b.getValue() - a.getValue());
        int range = 1, result = Integer.MIN_VALUE;
        
        for(int i = 0; i < points.length; i++) {
            while(range < points.length && points[range][0] - k <= points[i][0]) {
                pq.offer(new Pair(points[range][0], points[range][0] + points[range][1]));
                range++;
            }
            
            while(!pq.isEmpty() && pq.peek().getKey() <= points[i][0]) {
                pq.poll();
            }
            
            if(!pq.isEmpty()) {
                result = Math.max(result, pq.peek().getValue() - points[i][0] + points[i][1]);
            }
        }
        
        return result;
    }
}