// https://leetcode.com/problems/increasing-triplet-subsequence/
// 只需要在每个位置保存最小的两个，找到第三个返回true

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first_num = Integer.MAX_VALUE;
        int second_num = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= first_num) {
                first_num = n;
            } else if (n <= second_num) {
                second_num = n;
            } else {
                return true;
            }
        }
        return false;
    }
}