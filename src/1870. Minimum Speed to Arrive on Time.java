// https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
// 小binary search，稍微注意一点edge case处理

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour + 1 <= dist.length) {
            return -1;
        }
        
        int slow = 0, fast = 10000000;
        while(slow < fast - 1) {
            int mid = slow + (fast - slow) / 2;
            double time = 0;
            for(int i = 0; i < dist.length; i++) {
                if(i != dist.length - 1) {
                    time += dist[i] / mid;
                    if(dist[i] % mid != 0) {
                        time += 1;
                    }
                } else {
                    time += (double)dist[i] / (double)mid;
                }
            }
            if(time <= hour) {
                fast = mid;
            } else {
                slow = mid;
            }
        }
        return fast;
    }
}