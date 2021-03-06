// https://leetcode.com/problems/rotate-image/
// 两重循环分别换四个数，画图来确定坐标是什么

class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i < len / 2; i++) {
            for(int j = i; j < len - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - i - 1] = temp;
            }
        }
        return;
    }
}