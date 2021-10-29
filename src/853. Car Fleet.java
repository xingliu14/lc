// https://leetcode.com/problems/car-fleet/
// PriorityQueue完美解决

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<> (
            (a, b) -> b.getKey() - a.getKey());
        
        for(int i = 0; i < position.length; i++) {
            pq.offer(new Pair<Integer, Integer> (position[i], speed[i]));
        }
        
        int fleetCount = 0;
        float currTime = -1;
        
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            float newTime = (float) (target - pair.getKey()) / (float) pair.getValue();
            if(newTime > currTime) {
                currTime = newTime;
                fleetCount++;
            }
        }
        
        return fleetCount;
    }
}