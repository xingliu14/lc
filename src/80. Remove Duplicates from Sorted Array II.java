// 双指针，因为可以有两个相同的，所以是和head - 1比较

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) {
            return nums.length;
        }
        int head = 1, tail = 2;
        while(tail < nums.length) {
            if(nums[tail] != nums[head - 1]) {
                head += 1;
                nums[head] = nums[tail];
            }
            tail += 1;
        }
        return head + 1;
    }
}