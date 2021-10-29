// https://leetcode.com/problems/maximum-gap/
// 还可以用bucket sort，这是一个非比较性的稳定排序方法

class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for(int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }
}