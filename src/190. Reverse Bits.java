// https://leetcode.com/problems/reverse-bits/
// 一位一位

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int curr = n & 1;
            n >>>= 1;
            result <<= 1;
            result += curr;
        }
        return result;
    }
}