// https://leetcode.com/problems/find-peak-element/
//还有个二分法，但是需要证明才行

class Solution {
    public int findPeakElement(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if((i == 0 || nums[i] > nums[i - 1]) && (i == nums.length - 1 || nums[i] > nums[i + 1])) {
                return i;
            }
        }
        return -1;
    }
}