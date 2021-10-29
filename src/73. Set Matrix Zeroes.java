// https://leetcode.com/problems/set-matrix-zeroes/
// 使用最外面的行数来标记，但是它要单独标记

class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean first_row = false, first_col = false;
        
        for(int i = 0; i < row; i++) {
            if(matrix[i][0] == 0) {
                first_col = true;
                break;
            }
        }
        
        for(int j = 0; j < col; j++) {
            if(matrix[0][j] == 0) {
                first_row = true;
                break;
            }
        }
        
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < row; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int j = 1; j < col; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 1; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(first_row) {
            for(int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if(first_col) {
            for(int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}