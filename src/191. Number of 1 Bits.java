// https://leetcode.com/problems/number-of-1-bits/
// 特别注意，普通移位会保留之前的符号，需要>>>无符号移位

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}