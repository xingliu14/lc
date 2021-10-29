// https://leetcode.com/problems/3sum-smaller/
// x sum的问题最好的还是sort然后2 pointer

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi) {
                if(nums[i] + nums[lo] + nums[hi] < target) {
                    result += hi - lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return result;
    }
}