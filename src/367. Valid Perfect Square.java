// https://leetcode.com/problems/valid-perfect-square/submissions/
// 二分，对于overflow直接用long解决

class Solution {
    public boolean isPerfectSquare(int num) {
        long min = 1, max = num - 1;
        while(min <= max) {
            long mid = min + (max - min) / 2;
            if(mid * mid == (long) num) {
                return true;
            }
            if(mid * mid < (long) num) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min * min == num;
    }
}