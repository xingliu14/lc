// https://leetcode.com/problems/house-robber/
// 注意使用dp的情况，不需要考虑它具体是怎么选的，只需要知道它对应的是最大值即可。

class Solution {
    public int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}