// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
// 经典的rotate array的解法。特别注意的是因为有可能有重复，所以在mid = start的时候不能判断往哪走，

public class Solution {
    public boolean search(int[] nums, int target) {
        // note here end is initialized to len instead of (len-1)
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[start]) { // nums[start..mid] is sorted
                // check if target in left half
                if (target < nums[mid] && target >= nums[start]) end = mid;
                else start = mid + 1;
            } else if (nums[mid] < nums[start]) { // nums[mid..end] is sorted
                // check if target in right half
                if (target > nums[mid] && target <= nums[end]) start = mid + 1;
                else end = mid;
            } else { // have no idea about the array, but we can exclude nums[start] because nums[start] == nums[mid]
                start++;
            }
        }
        return false;
    }
}