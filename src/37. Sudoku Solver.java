// https://leetcode.com/problems/sudoku-solver/
// 基本就是暴力解，每一个试一下，然后递归进去，如果9个都试过了但是不行，那就返回false

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
        return;
    }
    
    private boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(char temp = '1'; temp <= '9'; temp++) {
                        if(isValid(board, i, j, temp)) {
                            board[i][j] = temp;
                            if(solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char temp) {
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == temp) {
                return false;
            }
            if(board[i][col] == temp) {
                return false;
            }
            if(board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == temp) {
                return false;
            }
        }
        return true;
    }
}