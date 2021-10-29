// https://leetcode.com/problems/maximum-product-subarray/
// 这道题很巧妙，主要就是0和负数在作怪，0比较好处理，直接全部清0即可。如果是负数的话，我需要维持正负最大的两个数，因为一旦遇到一个负数那我就两级反转。

class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0], currMax = nums[0], currMin = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int tempCurrMin = Math.min(nums[i], Math.min(currMin * nums[i], currMax * nums[i]));
            currMax = Math.max(nums[i], Math.max(currMin * nums[i], currMax * nums[i]));
            currMin = tempCurrMin;
            result = Math.max(result, currMax);
        }
        return result;
    }
}