// https://leetcode.com/problems/burst-balloons/
// dp加divide & conqure并且从后面网前面做
// 直接递归，并且从后往前很容易！

class Solution {
  private int[][] memo;
  private int[] vals;
  public int maxCoins(int[] nums) {
    final int n = nums.length;
    vals = new int[n + 2];
    for (int i = 0; i < n; ++i) vals[i + 1] = nums[i];
    vals[0] = vals[n + 1] = 1;
    memo = new int[n + 2][n + 2];
    return maxCoins(1, n);
  }
  
  private int maxCoins(int i, int j) {
    if (i > j) return 0;
    if (i == j) return vals[i - 1] * vals[i] * vals[i + 1];
    if (memo[i][j] > 0) return memo[i][j];
    int ans = 0;
    for (int k = i; k <= j; ++k)
      ans = Math.max(ans, maxCoins(i, k - 1) + vals[i - 1] * vals[k] * vals[j + 1] + maxCoins(k + 1, j));
    memo[i][j] = ans;
    return memo[i][j];
  }
}