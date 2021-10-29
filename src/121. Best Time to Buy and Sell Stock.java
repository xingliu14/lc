// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// 可以双pass。这个答案是单pass，只需要实时维持一个minPrice即可

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] > minPrice) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}