// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
// 这道题很难！考虑到两个交易不能重叠，我们可以divide&conquer，但是直接算复杂度太高，可以安排两个数组来存对应的最高profit。他还有一个办法scan一次并且不需要额外空间，很巧妙，详情见leetcode答案2。

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        int len = prices.length, maxProfit = 0, lowestPriceFromLeft = Integer.MAX_VALUE, highestPriceFromRight = Integer.MIN_VALUE;
        int[] maxProfitFromLeft = new int[len], maxProfitFromRight = new int[len];
        for(int i = 0; i < len; i++) {
            lowestPriceFromLeft = Math.min(lowestPriceFromLeft, prices[i]);
            maxProfitFromLeft[i] = i == 0 ? 0 : Math.max(maxProfitFromLeft[i - 1], prices[i] - lowestPriceFromLeft);
            
            highestPriceFromRight = Math.max(highestPriceFromRight, prices[len - 1 - i]);
            maxProfitFromRight[len - 1 - i] = i == 0 ? 0 : Math.max(maxProfitFromRight[len - i], highestPriceFromRight - prices[len - 1 - i]);
        }
        for(int i = 0; i <= len; i++) {
            int leftProfit = i == 0 ? 0 : maxProfitFromLeft[i - 1];
            int rightProfit = i == len ? 0 : maxProfitFromRight[i];
            maxProfit = Math.max(maxProfit, leftProfit + rightProfit);
        }
        return maxProfit;
    }
}