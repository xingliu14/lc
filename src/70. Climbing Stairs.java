// https://leetcode.com/problems/climbing-stairs/
// 可爱的小dp

class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2) {
            return n;
        }
        int step_0 = 1, step_1 = 2;
        for(int i = 3; i < n; i++) {
            if(step_0 < step_1) {
                step_0 = step_0 + step_1;
            } else {
                step_1 = step_0 + step_1;
            }
        }
        return step_0 + step_1;
    }
}