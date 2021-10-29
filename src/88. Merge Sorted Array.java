// https://leetcode.com/problems/merge-sorted-array/
// 从后往前即可简化

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr1 = m - 1, curr2 = n - 1;
        while(curr1 >= 0 && curr2 >= 0) {
            if(nums1[curr1] >= nums2[curr2]) {
                nums1[curr1 + curr2 + 1] = nums1[curr1];
                curr1 -= 1;
            } else {
                nums1[curr1 + curr2 + 1] = nums2[curr2];
                curr2 -= 1;
            }
        }
        if(curr1 == -1) {
            for(int i = curr2; i >= 0; i--) {
                nums1[i] = nums2[i];
            }
        }
    }
}