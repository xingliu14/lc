// https://leetcode.com/problems/container-with-most-water/
// 这里用的是双重循环，但还可以用双指针节省时间复杂度

class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        for(int i = 0; i < height.length - 1; i++) {
            for(int j = i + 1; j < height.length; j++) {
                result = Math.max(result, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return result;
    }
}