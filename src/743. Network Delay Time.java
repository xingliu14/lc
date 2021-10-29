// https://leetcode.com/problems/network-delay-time/
// 这道题太鸡巴抽象了，i循环了n次，但完全没有i出现，因为他在模拟信号传输！

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dis = new int[n + 1];
        Arrays.fill(dis, 10001);
        dis[k] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < times.length; j++) {
                dis[times[j][1]] = Math.min(dis[times[j][1]], dis[times[j][0]] + times[j][2]);
            }
        }
        
        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dis[i]);
        }
        return max == 10001 ? -1 : max;
    }
}