// https://leetcode.com/problems/sliding-window-maximum/
// 我就保留一个anchor来找最大值。可以用一个deque来存现在有的index来减少时间复杂度

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int index = -1;
        for(int i = 0; i < nums.length - k + 1; i++) {
            if(index < i) {
                index = i;
                for(int j = i + 1; j < i + k; j++) {
                    if(nums[j] >= nums[index]) {
                        index = j;
                    }
                }
            } else {
                if(nums[i + k - 1] > nums[index]) {
                    index = i + k - 1;
                }
            }
            result[i] = nums[index];
        }
        return result;
    }
}