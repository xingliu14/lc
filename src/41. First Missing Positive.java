// https://leetcode.com/problems/first-missing-positive/
// 既然需要找positive，那我们就把之前有的positive填到对应的位置，其他的不需要管，然后第一个没满足的数字既是答案

class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            while(nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < len; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}