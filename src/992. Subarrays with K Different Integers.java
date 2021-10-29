// https://leetcode.com/problems/subarrays-with-k-different-integers/
// 用双指针找正好这么多比较难，但是确定至少这么多很容易，那么他们的差就是结果！

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return lessOrEqualK(nums, k) - lessOrEqualK(nums, k - 1);
    }
    
    private int lessOrEqualK(int[] nums, int k) {
        int[] count = new int[nums.length + 1];
        int result = 0, start = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count[nums[i]] == 0) {
                k--;
            }
            count[nums[i]]++;
            while(k < 0) {
                count[nums[start]]--;
                if(count[nums[start]] == 0) {
                    k++;
                }
                start++;
            }
            result += i - start + 1;
        }
        return result;
    }
}