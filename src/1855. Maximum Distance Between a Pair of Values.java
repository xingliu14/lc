// https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
// 直接双指针搞起

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int result = 0;
        for(int i = 0; i < nums1.length; i++) {
            for(int j = i + result; j < nums2.length; j++) {
                if(nums1[i] <= nums2[j]) {
                    result++;
                } else {
                    break;
                }
            }
        }
        return Math.max(0, result - 1);
    }
}