// https://leetcode.com/problems/spiral-matrix-ii/
// 双重循环，四个转圈，最后看看中间是不是还剩一个洞

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n - i - 1; j++) {
                result[i][j] = count;
                result[j][n - 1 - i] = count + (n - 2 * i - 1);
                result[n - 1 - i][n - 1 - j] = count + 2 * (n - 2 * i - 1);
                result[n - 1 - j][i] = count + 3 * (n - 2 * i - 1);
                count += 1;
            }
            count += 3 * (n - 2 * i - 1);
        }
        if(n % 2 == 1) {
            result[n / 2][n / 2] = n * n;
        }
        return result;
    }
}