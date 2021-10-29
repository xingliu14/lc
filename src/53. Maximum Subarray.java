// https://leetcode.com/problems/maximum-subarray/
// 虽然是一道easy，但是还是用了DP的思想

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], currMax = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], nums[i] + currMax);
            max = Math.max(max, currMax);
        }
        return max;
    }
}