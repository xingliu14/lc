// https://leetcode.com/problems/find-k-th-smallest-pair-distance/
// binary search对应的是答案范围确定的问题，像这道题有点抽象但是也是。注意判断条件，怎么把答案锁定到一个valid answer。

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 0, max = nums[nums.length - 1] - nums[0];
        while(min <= max) {
            int mid = min + (max - min) / 2, count = 0;
            for(int i = 0; i < nums.length; i++) {
                int j = i + 1;
                while(j < nums.length && nums[j] - nums[i] <= mid) {
                    j++;
                }
                count += j - i - 1;
            }
            if(count >= k) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        
        return min;
    }
}