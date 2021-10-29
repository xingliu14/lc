// https://leetcode.com/problems/gas-station/
// 这道题我一顿优化，结果发现还是和暴力解没区别。one pass要用到一些数学推论，十分无聊而且tricky

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length, totalGas = 0, totalCost = 0, maxMargin = -1, index = -1, currMargin = -1;
        for(int i = 0; i < len; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currMargin = gas[i] - cost[i];
            if(currMargin > maxMargin) {
                maxMargin = currMargin;
                index = i;
            }
        }
        if(totalCost > totalGas) {
            return -1;
        }
        
        for(int i = 0; i < len; i++) {
            currMargin = gas[i] - cost[i];
            for(int j = 1; j < len; j++) {
                currMargin += gas[(i + j) % len] - cost[(i + j) % len];
                if(currMargin > maxMargin) {
                    maxMargin = currMargin;
                    index = i;
                }
            }
        }
        return index;
    }
}