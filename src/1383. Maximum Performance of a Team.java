// https://leetcode.com/problems/maximum-performance-of-a-team/
// 用PriorityQueue的时候先想想能不能用sort简单搞一下。还有就是最后结果返回mod的时候，先用long保存，最后在取mod变成int。不然中途很可能就错了。

class Solution {
    class engineer {
        int speed, efficiency;
        public engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final long MOD = 1000000007;
        PriorityQueue<engineer> pq = new PriorityQueue<> (
            (x, y) -> y.efficiency - x.efficiency);
        for(int i = 0; i < n; i++) {
            pq.offer(new engineer(speed[i], efficiency[i]));
        }
        long max = 0, sum = 0;
        PriorityQueue<Integer> speedPQ = new PriorityQueue<> ();
        for(int i = 0; i < k; i++) {
            engineer curr = pq.poll();
            speedPQ.offer(curr.speed);
            sum += curr.speed;
            max = Math.max(max, sum * curr.efficiency);
        }
        for(int i = k; i < n; i++) {
            engineer curr = pq.poll();
            speedPQ.offer(curr.speed);
            sum += curr.speed - speedPQ.poll();
            max = Math.max(max, sum * curr.efficiency);
        }
        return (int) (max % MOD);
    }
}