// https://leetcode.com/problems/valid-sudoku/
// labor work，分别用set验证一下有没有重复的即可

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<> ();
        for(int i = 0; i < 9; i++) {
            set.clear();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(set.contains(board[i][j]) || board[i][j] > '9' || board[i][j] < '1') {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
            
            set.clear();
            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.') {
                    if(set.contains(board[j][i]) || board[j][i] > '9' || board[j][i] < '1') {
                        return false;
                    }
                    set.add(board[j][i]);
                }
            }
            
            set.clear();
            int row = i / 3, col = i % 3;
            for(int j = 0; j < 9; j++) {
                int r = j / 3, c = j % 3;
                if(board[row * 3 + r][col * 3 + c] != '.') {
                    if(set.contains(board[row * 3 + r][col * 3 + c]) || board[row * 3 + r][col * 3 + c] > '9' || board[row * 3 + r][col * 3 + c] < '1') {
                        return false;
                    }
                    set.add(board[row * 3 + r][col * 3 + c]);
                }
            }
        }
        return true;
    }
}