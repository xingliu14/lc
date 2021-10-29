// https://leetcode.com/problems/search-insert-position/
// 普通二分，然后判断一下是插到head还是tail即可

class Solution {
    public int searchInsert(int[] nums, int target) {
        int head = 0, tail = nums.length - 1, mid;
        while(head <= tail) {
            mid = head + (tail - head) / 2;
            if(target == nums[mid]) {
                return mid;
            }
            if(target > nums[mid]) {
                head = mid + 1;
            } else {
                tail = mid - 1;
            }
        }
        return head;
    }
}