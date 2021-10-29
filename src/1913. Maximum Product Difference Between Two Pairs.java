// https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
// 简单

class Solution {
    public int maxProductDifference(int[] nums) {
        int max1 = 0, max2 = 0, min1 = 10001, min2 = 10001;
        for(int i : nums) {
            if(i > max1) {
                max2 = max1;
                max1 = i;
            } else if(i > max2) {
                max2 = i;
            }
            if(i < min1) {
                min2 = min1;
                min1 = i;
            } else if(i < min2) {
                min2 = i;
            }
        }
        
        return max1 * max2 - min1 * min2;
    }
}