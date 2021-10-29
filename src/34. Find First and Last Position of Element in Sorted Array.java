// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// 先用二分法找到一个，然后往两边分别去找剩下的

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int head = 0, tail = nums.length - 1, mid, index = -1, count = 0;
        while(head <= tail) {
            mid = head + (tail - head) / 2;
            if(nums[mid] == target) {
                index = mid;
                count += 1;
                break;
            }
            if(target > nums[mid]) {
                head = mid + 1;
            } else {
                tail = mid - 1;
            }
        }
        if(index == -1) {
            int[] result = {-1, -1};
            return result;
        }
        for(int i = index + 1; i < nums.length && nums[i] == target; i++) {
            count += 1;
        }
        for(index -= 1; index >= 0 && nums[index] == target; index--) {
            count += 1;
        }
        int[] result = {index + 1, index + count};
        return result;
    }
}