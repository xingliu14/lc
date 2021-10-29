// https://leetcode.com/problems/jump-game-ii/
// 和第一题差不多，还是每一步找下一步能跳得最远的，然后再记个数

class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0, curr = 0;
        while(curr + 1 < nums.length) {
            if(curr + nums[curr] + 1 >= nums.length) {
                result += 1;
                curr = nums.length;
            } else {
                int max = 0, max_step = 0;
                for(int i = 1; i <= nums[curr]; i++) {
                    if(max < i + nums[curr + i]) {
                        max = i + nums[curr + i];
                        max_step = i;
                    }
                }
                result += 1;
                curr += max_step;
            }
        }
        return result;
    }
}