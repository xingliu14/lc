// https://leetcode.com/problems/single-number/
// 狡诈的异或运算

class Solution {
  public int singleNumber(int[] nums) {
    int a = 0;
    for (int i : nums) {
      a ^= i;
    }
    return a;
  }
}