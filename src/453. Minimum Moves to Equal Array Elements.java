// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
// 简单

class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for(int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        return sum - min * nums.length;
    }
}