// https://leetcode.com/problems/continuous-subarray-sum/
// 既然只需要求是不是倍数，那就可以用%压缩

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            runningSum %= k; 
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else map.put(runningSum, i);
        }
        return false;
    }
}