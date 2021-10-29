// https://leetcode.com/problems/minimum-absolute-difference-queries/
// lc的这种傻逼题就需要对着dimension最小的点优化！

class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int[][] cnt = new int[101][nums.length + 1];
        
        for(int i = 0; i < nums.length; i++){
            int target = nums[i];
            for(int j = 1; j <= 100; j++) {
                cnt[j][i + 1] = cnt[j][i];
            }
            cnt[target][i + 1]++;
        }
        
        int[] ans = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++){
            boolean[] has = new boolean[101];
            
            for(int j = 1; j <= 100; j++){
                int thiscnt = cnt[j][queries[i][1] + 1] - cnt[j][queries[i][0]];
                if(thiscnt > 0) {
                    has[j] = true;
                }
            }
            
            int cur = -1;
            int subans = 9999;
            for(int j = 1; j <= 100; j++){
                if(has[j] && cur == -1) {
                    cur = j;
                }
                else if(has[j]) {
                    subans = Math.min(subans, j - cur);
                    cur = j;
                }
            }
            if(subans == 9999) {
                subans = -1;
            }
            ans[i] = subans;
        }
        
        return ans;
        
    }
}