// https://leetcode.com/problems/word-search-ii/
// 别想着优化了，直接硬怼

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<> ();
        for(String word : words) {
            outerloop:
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(existHelper(board, i, j, word, 0)) {
                        result.add(word);
                        break outerloop;
                    }
                }
            }
        }
        return result;
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