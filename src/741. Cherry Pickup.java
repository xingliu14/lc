// https://leetcode.com/problems/cherry-pickup/
// 这个狗逼方法把两条路线放在一起考虑，竟然变成了完美的dp，不过要维护三维矩阵确实是心累

class Solution {
    private int[][][] cache;
    private int[][] grid;
    private int size;
    
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.size = grid.length;
        cache = new int[size][size][size];
        for(int[][] layer : cache) {
            for(int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        return Math.max(0, dp(0, 0, 0));
    }
    
    private int dp(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        if(r1 == size || c1 == size || r2 == size || c2 == size || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        } else if(r1 == size - 1 && c1 == size - 1) {
            return grid[size - 1][size - 1];
        } else if(cache[r1][c1][r2] != Integer.MIN_VALUE) {
            return cache[r1][c1][r2];
        } else {
            int ans = grid[r1][c1];
            if (c1 != c2) ans += grid[r2][c2];
            ans += Math.max(Math.max(dp(r1, c1+1, r2+1), dp(r1+1, c1, r2+1)),
                            Math.max(dp(r1, c1+1, r2), dp(r1+1, c1, r2)));
            cache[r1][c1][r2] = ans;
            return ans;
        }
    }
}