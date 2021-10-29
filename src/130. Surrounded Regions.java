// https://leetcode.com/problems/surrounded-regions/
// 需要想到：能跑掉的O全都是和四周连在一起的O，于是我先把和四周连在一起的O保护起来，然后把剩下的O歼灭，最后把保护起来的O平反

class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }
        
        int row = board.length, col = board[0].length;
        
        for(int i = 0; i < col; i++) {
            flipAdj(board, 0, i);
            flipAdj(board, row - 1, i);
        }
        for(int i = 0; i < row; i++) {
            flipAdj(board, i, 0);
            flipAdj(board, i, col - 1);
        }
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void flipAdj(char[][] board, int row, int col) {
        if(board[row][col] == 'O') {
            board[row][col] = 'S';
            if(row > 0) {
                flipAdj(board, row - 1, col);
            }
            if(col > 0) {
                flipAdj(board, row, col - 1);
            }
            if(row < board.length - 1) {
                flipAdj(board, row + 1, col);
            }
            if(col < board[0].length - 1) {
                flipAdj(board, row, col + 1);
            }
        } else {
            return;
        }
    }
}