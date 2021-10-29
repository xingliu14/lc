// https://leetcode.com/problems/sort-colors/
// 眼花缭乱的三指针

class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length - 1;
        while(white <= blue) {
            if(nums[white] == 0) {
                nums[white++] = nums[red];
                nums[red++] = 0;
            } else if(nums[white] == 1) {
                white += 1;
            } else {
                nums[white] = nums[blue];
                nums[blue--] = 2;
            }
        }
    }
}