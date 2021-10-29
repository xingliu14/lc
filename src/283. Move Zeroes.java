// https://leetcode.com/problems/move-zeroes/
// 首先观察一下移动的规律，就知道了用一个count往前移即可，特别注意最后的改为0需要判断一下

class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
                if(count != 0) {
                    nums[i] = 0;
                }
            }
        }
        return;
    }
}