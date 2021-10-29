// https://leetcode.com/problems/squares-of-a-sorted-array/
// 双指针

class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length, left = -1, right = 0, count = 0;
        int[] result = new int[len];
        for(int i = 0; i < len; i++) {
            if(nums[i] < 0) {
                left = i;
                right = i + 1;
            } else {
                break;
            }
        }
        while(left >= 0 && right < len) {
            if(Math.abs(nums[left]) > nums[right]) {
                result[count++] = nums[right] * nums[right++];
            } else {
                result[count++] = nums[left] * nums[left--];
            }
        }
        while(left >= 0) {
            result[count++] = nums[left] * nums[left--];
        }
        while(right < len) {
            result[count++] = nums[right] * nums[right++];
        }
        return result;
    }
}