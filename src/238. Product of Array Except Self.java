// https://leetcode.com/problems/product-of-array-except-self/
// 使用divide & conqure，分别造两个数组，代表左边和右边。还可以只用一个答案数组，然后run的时候再用另一个单独的数来保存。

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len], left = new int[len], right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for(int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[len - 1 - i] = right[len - i] * nums[len - i];
        }
        for(int i = 0; i < len; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}