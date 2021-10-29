// https://leetcode.com/problems/powx-n/
// 相当于divide & conqure，注意复数的情况要加一因为考虑到Integer.MIN_VALUE的情况

class Solution {
    double myPow(double x, int n) { 
        if(n == 0) return 1;
        if(n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}