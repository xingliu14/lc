// https://leetcode.com/problems/factorial-trailing-zeroes/
// 只需要关注5即可，然后用不同的5的幂来一层一层剥削，就达到了log的效果

class Solution {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        // We need to use long because currentMultiple can potentially become
        // larger than an int.
        long currentMultiple = 5;
        while (n >= currentMultiple) {
            zeroCount += (n / currentMultiple);
            currentMultiple *= 5;
        }
        return zeroCount;
    }
}