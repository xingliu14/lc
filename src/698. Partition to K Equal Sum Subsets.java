// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/submissions/
// 这种解法c++能过，java就tle。不过重要的知识是，在不确定该怎么判断的时候，直接暴力搜索。

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % k != 0) {
            return false;
        }
        sum /= k;
        Arrays.sort(nums);
        return dfs(nums, k, sum, 0, 0);
    }
    
    private boolean dfs(int[] nums, int k, int sum, int curr, int visited) {
        if(k == 0) {
            return true;
        }
        for(int i = 0; i < nums.length; i++) {
            if((visited & (1 << i)) != 0) {
                continue;
            }
            if(curr + nums[i] > sum) {
                break;
            }
            int new_visited = visited | (1 << i);
            if(curr + nums[i] == sum) {
                if(dfs(nums, k - 1, sum, 0, new_visited)) {
                    return true;
                }
            } else {
                if(dfs(nums, k, sum, curr + nums[i], new_visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}