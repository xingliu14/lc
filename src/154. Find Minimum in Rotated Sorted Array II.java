// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
// 这道题只需要搞定这个test case就没问题了：[10, 1, 10, 10, 10]。在遇到相等的情况的时候，需要一位一位的移，并且还需要判断首尾有没有答案

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int head = 0, tail = nums.length - 1, mid;
        while(head < tail) {
            mid = head + (tail - head) / 2;
            if(nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if(nums[mid] == nums[head] || nums[mid] == nums[tail]) {
                if(nums[mid] == nums[head]) {
                    if(nums[head] > nums[head + 1]) {
                        return nums[head + 1];
                    } else {
                        head += 1;
                    }
                }
                if(nums[mid] == nums[tail]) {
                    if(nums[tail] < nums[tail - 1]) {
                        return nums[tail];
                    } else {
                        tail -= 1;
                    }
                }
            } else {
                if(nums[mid] > nums[head]) {
                    head = mid + 1;
                } else {
                    tail = mid;
                }
            }
        }
        return nums[0];
    }
}