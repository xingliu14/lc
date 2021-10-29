// https://leetcode.com/problems/jump-game/
// 每一次从可以跳到的点里选接下来一步能跳到最远的点即可

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }
        int curr = 0;
        while(curr < nums.length - 1) {
            if(nums[curr] == 0) {
                return false;
            }
            if(curr + nums[curr] >= nums.length - 1) {
                return true;
            }
            int max = curr, max_i = 0;
            for(int i = 1; i <= nums[curr]; i++) {
                if(max < curr + i + nums[curr + i]) {
                    max = curr + i + nums[curr + i];
                    max_i = i;
                }
            }
            curr += max_i;
        }
        return true;
    }
}