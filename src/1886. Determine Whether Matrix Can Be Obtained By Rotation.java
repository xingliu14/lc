// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
// 直接比较

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean found1 = true, found2 = true, found3 = true, found4 = true;
        outter:
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] != target[i][j]) {
                    found1 = false;
                }
                if(mat[n - 1 - j][i] != target[i][j]) {
                    found2 = false;
                }
                if(mat[n - 1 - i][n - 1 - j] != target[i][j]) {
                    found3 = false;
                }
                if(mat[j][n - 1 - i] != target[i][j]) {
                    found4 = false;
                }
            }
        }
        return(found1 || found2 || found3 || found4);
    }
}