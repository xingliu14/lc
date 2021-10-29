// https://leetcode.com/problems/moving-average-from-data-stream/
// Google原题

class MovingAverage {
    
    int[] cache;
    int curr, size;
    int currSum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = 0;
        cache = new int[size];
        curr = 0;
        currSum = 0;
    }
    
    public double next(int val) {
        currSum += val - cache[curr];
        cache[curr] = val;
        size = Math.min(size + 1, cache.length);
        curr = (curr + 1) % cache.length;
        return (double) currSum / (double) size;
    }
}