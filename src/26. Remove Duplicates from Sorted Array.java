// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// 往后面找不重复的填充前面

class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = 0, count = 0, dup = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] != curr) {
                curr = nums[i];
                nums[i - dup] = nums[i];
                count += 1;
            } else {
                dup += 1;
            }
        }
        return count;
    }
}