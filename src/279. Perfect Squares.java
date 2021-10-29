// https://leetcode.com/problems/perfect-squares/
// dp虽然在这题不是最优，但是好使

class Solution {
    public int numSquares(int n) {
        int[] mem = new int[n + 1];
        mem[1] = 1;
        return findMin(n, mem);
    }
    
    private int findMin(int target, int[] mem) {
        if(mem[target] != 0 || target == 0) {
            return mem[target];
        }
        int root = 1, min = Integer.MAX_VALUE;
        while(root * root <= target) {
            min = Math.min(min, 1 + findMin(target - root * root, mem));
            root++;
        }
        mem[target] = min;
        return min;
    }
}