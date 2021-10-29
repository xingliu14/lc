// bfs即可，需要注意用了一个字母之后需要划掉它，最后再改回来

public class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                if(existHelper(board, i, j, word, 0)) {
                    return true;
                }
            }
        return false;
    }
    
    private boolean existHelper(char[][] board, int i, int j, String word, int ind){
        if(ind == word.length()) {
            return true;
        }
        if(i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(ind))
            return false;
        board[i][j]='*';
        boolean result = existHelper(board, i - 1, j, word, ind + 1) ||
                         existHelper(board, i, j - 1, word, ind + 1) ||
                         existHelper(board, i, j + 1, word, ind + 1) ||
                         existHelper(board, i + 1, j, word, ind + 1);
        board[i][j] = word.charAt(ind);
        return result;
    }
}