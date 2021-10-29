// https://leetcode.com/problems/house-robber-ii/
// 巧妙地敲掉第一个或最后一个，就变成了初代题

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int prev1 = 0, curr1 = 0, prev2 = 0, curr2 = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int temp1 = curr1, temp2 = curr2;
            curr1 = Math.max(curr1, prev1 + nums[i]);
            curr2 = Math.max(curr2, prev2 + nums[i + 1]);
            prev1 = temp1;
            prev2 = temp2;
        }
        return Math.max(curr1, curr2);
    }
}