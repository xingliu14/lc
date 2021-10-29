// https://leetcode.com/problems/range-sum-query-2d-mutable/
// 套用一维的情况，就简单的做很多个一维

class NumMatrix {
    
    private int[][] cache;
    private int[][] mat;
    private int row;
    private int col;

    public NumMatrix(int[][] matrix) {
        mat = matrix;
        row = matrix.length;
        col = (int) Math.ceil(mat[0].length / Math.sqrt(mat[0].length));
        cache = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                cache[i][j / col] += mat[i][j];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int col_index = col / this.col;
        cache[row][col_index] += val - mat[row][col];
        mat[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        int start_block = col1 / this.col, end_block = col2 / this.col;
        for(int r = row1; r <= row2; r++) {
            if(start_block == end_block) {
                for(int c = col1; c <= col2; c++) {
                    sum += mat[r][c];
                }
            } else {
                for(int c = col1; c < (start_block + 1) * col; c++) {
                    sum += mat[r][c];
                }
                for(int b = start_block + 1; b < end_block; b++) {
                    sum += cache[r][b];
                }
                for(int c = end_block * col; c <= col2; c++) {
                    sum += mat[r][c];
                }
            }
        }
        
        return sum;
    }
}