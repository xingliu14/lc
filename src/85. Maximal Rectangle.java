// https://leetcode.com/problems/maximal-rectangle/
// 这道题用dp。维持三个数组：左边界、右边界和高度，三个数组只在为1的时候更新，然后计算最大的面积。需要左右各一次扫描。还可以把它当做找最大的histogram来做，那就变成了上一道题。

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length, maxRec = 0;
        int[] height = new int[col], left = new int[col], right = new int[col];
        Arrays.fill(right, col - 1);
        for(int i = 0; i < row; i++) {
            int rightBound = col - 1;
            for(int j = col - 1; j >= 0; j--) {
                if(matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rightBound);
                } else {
                    right[j] = col - 1;
                    rightBound = j - 1;
                }
            }
            int leftBound = 0;
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') {
                    height[j] += 1;
                    left[j] = Math.max(left[j], leftBound);
                    maxRec = Math.max(maxRec, height[j] * (right[j] - left[j] + 1));
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    leftBound = j + 1;
                }
            }
        }
        return maxRec;
    }
}