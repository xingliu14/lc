// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// 二分法要非常注意答案是否在范围内，然后调整head和tail使得条件在范围内，然后再根据变化规律设置循环结束条件

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int head = 0, tail = nums.length - 1;
        while(head < tail) {
            int mid = head + (tail - head) / 2;
            if(nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if(nums[mid] > nums[head]) {
                head = mid + 1;
            } else {
                tail = mid;
            }
        }
        return nums[0];
    }
}