// https://leetcode.com/problems/next-permutation/
// 详情见注释，关键是要想到什么样的数才是下一个数

class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        // 找前面的数比后面小的位置
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        // 如果没找到，那就变成最小的升序排列
        if(index == -1) {
            for(int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
            return;
        }
        // 先找到比index的数大的最小的数，我们需要交换他们
        for(int i = nums.length - 1; i > index; i--) {
            if(nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                // 交换的数及它之后的数都是递减的，我们需要改成递增的，就是下一个数
                for(int j = index + 1; j < (index + nums.length + 1) / 2; j++) {
                    int temp2 = nums[j];
                    nums[j] = nums[index + nums.length - j];
                    nums[index + nums.length - j] = temp2;
                }
                return;
            }
        }
        return;
    }
}