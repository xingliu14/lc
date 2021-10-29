// https://leetcode.com/problems/rotate-array/
// 可以通过观察，发现直接reverse三次即可。如果正常做的话可以for循环套一个while循环！for循环的条件和增加的值可以不一样！

class Solution {
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }
  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}