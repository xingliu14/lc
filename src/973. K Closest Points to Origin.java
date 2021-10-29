// https://leetcode.com/problems/k-closest-points-to-origin/
// PriorityQueue轻松解决

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Comparator<int[]> comp = new Comparator<> () {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] * p1[0] - p2[0] * p2[0] + p1[1] * p1[1] - p2[1] * p2[1];
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<> (comp);
        for(int[] point : points) {
            pq.offer(point);
        }
        int[][] result = new int[K][2];
        for(int i = 0; i < K; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}