// https://leetcode.com/problems/spiral-matrix/
// 设置一个passed来处理最后可能的一条

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<> ();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length, cols = matrix[0].length, passed = 0;
        
        while((passed + 1) * 2 <= Math.min(rows, cols)) {
            for(int i = passed; i < cols - passed; i++) {
                result.add(matrix[passed][i]);
            }
            for(int i = passed + 1; i < rows - passed; i++) {
                result.add(matrix[i][cols - 1 - passed]);
            }
            for(int i = cols - 2 - passed; i >= passed; i--) {
                result.add(matrix[rows - 1 - passed][i]);
            }
            for(int i = rows - 2 - passed; i > passed; i--) {
                result.add(matrix[i][passed]);
            }
            passed += 1;
        }
        
        if(Math.min(rows, cols) % 2 == 1) {
            if(rows < cols) {
                for(int i = passed; i < cols - passed; i++) {
                    result.add(matrix[passed][i]);
                }
            } else {
                for(int i = passed; i < rows - passed; i++) {
                    result.add(matrix[i][passed]);
                }
            }
        }
        
        return result;
    }
}