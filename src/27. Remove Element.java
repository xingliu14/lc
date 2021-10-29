// https://leetcode.com/problems/remove-element/
// 和in place消除重复类似

class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                count += 1;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }
}