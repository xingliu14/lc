// https://leetcode.com/problems/majority-element/
// 利用majority可以单挑所有剩下的数的特性

class Solution {
    public int majorityElement(int[] nums) {
        int curr = 0, count = 0;
        for(int num : nums) {
            if(count == 0) {
                curr = num;
                count = 1;
            } else {
                count += num == curr ? 1 : -1;
            }
        }
        return curr;
    }
}