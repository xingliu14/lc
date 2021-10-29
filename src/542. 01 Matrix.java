// https://leetcode.com/problems/01-matrix/
// 如果用dp的话，需要看穿它其实就是两个方向，交叉dp一次。bfs的话就是分布式bfs。

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] result = new int[m][n];
        for(int[] row : result) {
            Arrays.fill(row, 100000);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) {
                    if(i > 0) {
                        result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                    }
                    if(j > 0) {
                        result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                    }
                } else {
                    result[i][j] = 0;
                }
            }
        }
        
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i != m - 1) {
                    result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                }
                if(j != n - 1) {
                    result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
                }
            }
        }
        
        return result;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] result = new int[m][n];
        Set<Pair<Integer, Integer>> visited = new HashSet<> ();
        List<Pair<Integer, Integer>> curr = new LinkedList<> ();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    curr.add(new Pair<Integer, Integer> (i, j));
                    visited.add(new Pair<Integer, Integer> (i, j));
                }
            }
        }
        
        int dis = 0;
        int[] xDir = {0, 1, 0, -1}, yDir = {1, 0, -1, 0};
        while(!curr.isEmpty()) {
            dis++;
            List<Pair<Integer, Integer>> next = new LinkedList<> ();
            for(Pair<Integer, Integer> p : curr) {
                int currX = p.getKey(), currY = p.getValue();
                for(int i = 0; i < 4; i++) {
                    int newX = currX + xDir[i], newY = currY + yDir[i];
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n || visited.contains(new Pair<Integer, Integer> (newX, newY))) {
                        continue;
                    }
                    result[newX][newY] = dis;
                    visited.add(new Pair<Integer, Integer> (newX, newY));
                    next.add(new Pair<Integer, Integer> (newX, newY));
                }
            }
            curr = next;
        }
        
        return result;
    }
}