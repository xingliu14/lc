// https://leetcode.com/problems/consecutive-numbers-sum/
// 这道题好蠢，就是数学题

class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 0, diff = 0;
        for(int i = 1; i + diff <= N; i++) {
            if((N - diff) % i == 0) {
                count++;
            }
            diff += i;
        }
        return count;
    }
}