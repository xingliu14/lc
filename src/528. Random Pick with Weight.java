// https://leetcode.com/problems/random-pick-with-weight/
// 标准的随机数解法

class Solution {
    private int[] prefixSums;
    private int totalSum;
    private Random rand;

    public Solution(int[] w) {
        this.rand = new Random();
        this.prefixSums = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }

    public int pickIndex() {
        int index = this.rand.nextInt(totalSum);
        
        // run a binary search to find the target zone
        int low = 0, high = this.prefixSums.length;
        while (low < high) {
            // better to avoid the overflow
            int mid = low + (high - low) / 2;
            if (index >= this.prefixSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}