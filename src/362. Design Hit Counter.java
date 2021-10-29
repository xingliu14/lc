// https://leetcode.com/problems/design-hit-counter/
// 就利用TreeMap的排序特性

class HitCounter {
    
    private TreeMap<Integer, Integer> map;
    private int count;

    /** Initialize your data structure here. */
    public HitCounter() {
        map = new TreeMap<> ();
        count = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
        count++;
        return;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        Set<Integer> set = new HashSet<> ();
        for(int ts : map.keySet()) {
            if(ts <= timestamp - 300) {
                count -= map.get(ts);
                set.add(ts);
            } else {
                break;
            }
        }
        for(int ts : set) {
            map.remove(ts);
        }
        return count;
    }
}