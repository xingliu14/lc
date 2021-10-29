// https://leetcode.com/problems/largest-rectangle-in-histogram/
// divide & conqure还比较好理解，但是最快的stack方法真的让人脑壳疼

public class Solution {
    public int largestRectangleArea(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }
    
    private int calculateArea(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        int minindex = start;
        for (int i = start; i <= end; i++) {
            if (heights[minindex] > heights[i]) {
                minindex = i;
            }
        }
        return Math.max(heights[minindex] * (end - start + 1), Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
    }
}