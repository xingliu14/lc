// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
// 我他妈真的是逻辑思维大师

class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE, size = nums.length;
        
        min = Math.min(min, nums[size - 4] - nums[0]);
        min = Math.min(min, nums[size - 3] - nums[1]);
        min = Math.min(min, nums[size - 2] - nums[2]);
        min = Math.min(min, nums[size - 1] - nums[3]);
        
        return min;
    }
}