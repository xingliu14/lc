// https://leetcode.com/problems/new-21-game/
// 需要优化一下变成1 pass

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(n >= k + maxPts) {
            return 1;
        }
        
        double[] psbly = new double[k + maxPts];
        psbly[0] = 1;
        double prev = 0;
        for(int i = 1; i < k + maxPts; i++) {
            prev = prev + (i - 1 < k ? psbly[i - 1] : 0) - (i - maxPts - 1 >= 0 ? psbly[i - maxPts - 1] : 0);
            psbly[i] = prev / (double) maxPts;
        }
        
        double result = 0;
        for(int i = k; i <= n; i++) {
            result += psbly[i];
        }
        
        return result;
    }
}