// https://leetcode.com/problems/search-in-rotated-sorted-array/
// 一般的二分法可以从两边判断，但这道题因为存在一个割裂点，所以我们需要找到容易判断的一边判断并进行操作，另一边就用else处理即可

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        int head = 0, tail = nums.length - 1, mid;
        while(head <= tail) {
            mid = head + (tail - head) / 2;
            if(target == nums[mid]) {
                return mid;
            } else if(nums[head] <= nums[mid]) {
                if(target >= nums[head] && target < nums[mid]) {
                    tail = mid - 1;
                } else {
                    head = mid + 1;
                }
            } else {
                if(target <= nums[tail] && target > nums[mid]) {
                    head = mid + 1;
                } else {
                    tail = mid - 1;
                }
            }
        }
        return -1;
    }
}