// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
// 双重PriorityQueue大法

class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Pair<Integer, Integer>> future = new PriorityQueue<> (
                                                            (p1, p2) -> p1.getKey() - p2.getKey()),
                                              available = new PriorityQueue<> (
                                                            (p1, p2) -> p1.getValue() - p2.getValue());
        for(int[] event : events) {
            future.offer(new Pair<Integer, Integer> (event[0], event[1]));
        }
        int time = 1, result = 0;
        while(!future.isEmpty() || !available.isEmpty()) {
            while(!future.isEmpty() && future.peek().getKey() <= time) {
                available.offer(future.poll());
            }
            while(!available.isEmpty() && available.peek().getValue() < time) {
                available.poll();
            }
            if(!available.isEmpty()) {
                available.poll();
                result++;
            }
            time++;
        }
        return result;
    }
}