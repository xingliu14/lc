// https://leetcode.com/problems/longest-consecutive-sequence/
// 虽然是个hard，但是用Sort可以很容易地做出来。还有一个O(n)的算法，是用set，然后需要论证一下看上去是O(n^2)的算法其实是O(n)的。

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 1, count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1] + 1) {
                count++;
                result = Math.max(result, count);
            } else if(nums[i] == nums[i - 1]) {
                continue;
            } else {
                count = 1;
            }
        }
        return result;
    }
}