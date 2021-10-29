// https://leetcode.com/problems/median-of-two-sorted-arrays/
// 利用Divide and Conqure，使用递归加二分，每次只在一个array上前进一般的路程，稍微注意基础情况

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if((m + n) % 2 == 0) {
            int result1 = findKth(nums1, 0, nums2, 0, (m + n) / 2);
            int result2 = findKth(nums1, 0, nums2, 0, (m + n) / 2 + 1);
            return ((double) result1 + (double) result2) / 2;
        }
        int result = findKth(nums1, 0, nums2, 0, (m + n) / 2 + 1);
        return (double) result;
    }
    
    private int findKth(int[] nums1, int start1, int[] nums2, int start2, int len) {
        if(start1 >= nums1.length) {
            return nums2[start2 + len - 1];
        }
        if(start2 >= nums2.length) {
            return nums1[start1 + len - 1];
        }
        if(len == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int v1 = start1 + len / 2 - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[start1 + len / 2 - 1];
        int v2 = start2 + len / 2 - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[start2 + len / 2 - 1];
        if(v1 < v2) {
            return findKth(nums1, start1 + len / 2, nums2, start2, len - len / 2);
        }
        return findKth(nums1, start1, nums2, start2 + len / 2, len - len / 2);
    }
}