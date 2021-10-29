// https://leetcode.com/problems/target-sum/
// 最后发现这种遍历的还是得靠backtrack，不需要存路径，只需在最后加个数

class Solution {
    int result = 0;
    
    public int findTargetSumWays(int[] nums, int target) {
        int diff = 0;
        for(int num : nums) {
            diff += num;
        }
        if(diff < target || (diff - target) % 2 == 1) {
            return 0;
        }
        diff = (diff - target) / 2;
        backtrack(diff, 0, nums);
        return result;
    }
    
    private void backtrack(int res, int index, int[] nums) {
        if(res == 0) {
            result++;
        }
        if(res < 0) {
            return;
        }
        for(int i = index; i < nums.length; i++) {
            backtrack(res - nums[i], i + 1, nums);
        }
    }
}